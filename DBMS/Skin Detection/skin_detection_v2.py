# Store and print shapes of images with skin
import cv2
import os
import random
import numpy as np

# Count of Skin Colors
skin_rgb_cnt = np.zeros(shape=(256, 256, 256))

# Count of Non-Skin Colors
non_skin_rgb_cnt = np.zeros(shape=(256, 256, 256))

# track train images
track_train_img = np.zeros(shape=(555))

# Final probalities
trained_value = np.zeros(shape=(256, 256, 256))

total_image = 555
train_image = 500
test_image = 55
total_skin_color = 0
total_non_skin_color = 0
false_negative = 0
false_positive = 0
true_positive = 0
true_negative = 0
k_fold = 10

# get all image names in sequential order from both ibtd and Mask folder
images = os.listdir('ibtd')
mask_images = os.listdir('Mask')

# crossfold validation k = 10
for i in range(k_fold):
    
    print("********Iteration: ", i+1)
    
    # shuffle the image order
    indices = ["%04d" % x for x in range(total_image)]
    random.shuffle(indices)

    # count each pixel RGB value of the imgaes
    for index in range(train_image):
        actual_image = cv2.imread("ibtd/" + str(indices[index]) + ".jpg")
        mask_image = cv2.imread("Mask/" + str(indices[index]) + ".bmp")
        height, width, channel = mask_image.shape

        # images have been trained, so skip while testing
        track_train_img[int(indices[index])] = 1

        for x in range(height):
            for y in range(width):
                mask_blue = mask_image[x, y, 0]
                mask_green = mask_image[x, y, 1]
                mask_red = mask_image[x, y, 2]

                blue = actual_image[x, y, 0]
                green = actual_image[x, y, 1]
                red = actual_image[x, y, 2]

                if mask_blue > 250 and mask_green > 250 and mask_red > 250:  # means it's NON-SKIN
                    non_skin_rgb_cnt[red, green, blue] += 1
                    total_non_skin_color += 1
                else:
                    skin_rgb_cnt[red, green, blue] += 1
                    total_skin_color += 1

        print(index)


    # fp = open('output3.txt', 'w')
    # iterate over all possible RGB combinations
    # and calculate the probability of each color
    for r in range(256):
        for g in range(256):
            for b in range(256):
                skin_prob = skin_rgb_cnt[r, g, b] / total_skin_color               # P(C|S)
                non_skin_prob = non_skin_rgb_cnt[r, g, b] / total_non_skin_color   # P(C|NS)

                if (non_skin_rgb_cnt[r, g, b] != 0):                                # P(C|S) / P(C|NS)
                    trained_value[r, g, b] = skin_prob / non_skin_prob
                else:
                    trained_value[r, g, b] = 0.0
                
                tmp = trained_value[r, g, b]
                # fp.write(f"{tmp}\n")
                
    # fp.close()

    print(i+1, " TRAIN DONE!!")
    ##### TRAINING DONE #####


    ##### TESTING #####
    T = 0.4
    f2 = open('confusion_matrix.txt', 'w')
    for index in range(total_image):  # can be done using stack

        if track_train_img[int(indices[index])] == 0:  # this image is for TESTING

            actual_image = cv2.imread("ibtd/" + str(indices[index]) + ".jpg")
            mask_image = cv2.imread("Mask/" + str(indices[index]) + ".bmp")
            height, width, channel = mask_image.shape

            
            for x in range(height):
                for y in range(width):
                    blue = actual_image[x, y, 0]
                    green = actual_image[x, y, 1]
                    red = actual_image[x, y, 2]

                    maskBlue = mask_image[x, y, 0]
                    maskGreen = mask_image[x, y, 1]
                    maskRed = mask_image[x, y, 2]

                    if (trained_value[red, green, blue] <= T) and (maskRed > 250 and maskGreen > 250 and maskBlue > 250):
                        # NON-SKIN - NON-SKIN [True Negative]
                        true_negative += 1

                    elif (trained_value[red, green, blue] <= T) and (maskRed < 250 or maskGreen < 250 or maskBlue < 250):
                        # NON-SKIN - SKIN [False Negative]
                        false_negative += 1

                    elif (trained_value[red, green, blue] > T) and (maskRed > 250 and maskGreen > 250 and maskBlue > 250):
                        # SKIN - NON-SKIN [False Positive]
                        false_positive += 1

                    elif (trained_value[red, green, blue] > T) and (maskRed < 250 or maskGreen < 250 or maskBlue < 250):
                        # SKIN - SKIN [True Positive]
                        true_positive += 1
            
                
    print("TP: ", true_positive, " TN: ", true_negative, " FP: ", false_positive, " FN: ", false_negative)
    # f2.write(f"TP: {true_positive} TN: {true_negative} FP: {false_positive} FN: {false_negative}\n")
       
true_positive /= k_fold
true_negative /= k_fold
false_positive /= k_fold
false_negative /= k_fold
accuracy = (true_positive+true_negative)/(true_positive+true_negative+false_positive+false_negative)

print("TP: ", true_positive, " TN: ", true_negative, " FP: ", false_positive, " FN: ", false_negative)
print("ACCURACY: ", accuracy)
f2.write(f"AVG \nTP: {true_positive} TN: {true_negative} FP: {false_positive} FN: {false_negative}\n")
f2.write(f"\nACCURACY: {accuracy}\n")

f2.close()
        

