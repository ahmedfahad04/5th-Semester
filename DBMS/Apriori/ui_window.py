# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file '.\mainwindow.ui'
#
# Created by: PyQt5 UI code generator 5.15.4
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(992, 607)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.gridLayout_3 = QtWidgets.QGridLayout(self.centralwidget)
        self.gridLayout_3.setObjectName("gridLayout_3")
        self.tabWidget = QtWidgets.QTabWidget(self.centralwidget)
        font = QtGui.QFont()
        font.setPointSize(16)
        self.tabWidget.setFont(font)
        self.tabWidget.setStyleSheet("background-color: bisque;")
        self.tabWidget.setTabShape(QtWidgets.QTabWidget.Rounded)
        self.tabWidget.setIconSize(QtCore.QSize(50, 50))
        self.tabWidget.setElideMode(QtCore.Qt.ElideLeft)
        self.tabWidget.setObjectName("tabWidget")
        self.stock_tab = QtWidgets.QWidget()
        self.stock_tab.setObjectName("stock_tab")
        self.gridLayout_4 = QtWidgets.QGridLayout(self.stock_tab)
        self.gridLayout_4.setObjectName("gridLayout_4")
        self.update_inventory_btn = QtWidgets.QPushButton(self.stock_tab)
        self.update_inventory_btn.setMinimumSize(QtCore.QSize(0, 50))
        font = QtGui.QFont()
        font.setPointSize(15)
        self.update_inventory_btn.setFont(font)
        self.update_inventory_btn.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        self.update_inventory_btn.setStyleSheet("QPushButton {\n"
"background-color: rgb(224, 122, 95);\n"
"color:  rgb(0, 43, 91);\n"
"border-radius: 10px;\n"
"}\n"
"\n"
"QPushButton::hover:!pressed {\n"
"    \n"
"    background-color: rgb(199, 107, 84);\n"
"    color: rgb(0, 43, 91);\n"
"\n"
"}")
        self.update_inventory_btn.setObjectName("update_inventory_btn")
        self.gridLayout_4.addWidget(self.update_inventory_btn, 1, 0, 1, 1)
        self.reload_btn = QtWidgets.QPushButton(self.stock_tab)
        self.reload_btn.setMinimumSize(QtCore.QSize(0, 50))
        font = QtGui.QFont()
        font.setPointSize(15)
        self.reload_btn.setFont(font)
        self.reload_btn.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        self.reload_btn.setStyleSheet("QPushButton {\n"
"background-color: rgb(224, 122, 95);\n"
"color:  rgb(0, 43, 91);\n"
"border-radius: 10px;\n"
"}\n"
"\n"
"QPushButton::hover:!pressed {\n"
"    \n"
"    background-color: rgb(199, 107, 84);\n"
"    color: rgb(0, 43, 91);\n"
"\n"
"}")
        self.reload_btn.setObjectName("reload_btn")
        self.gridLayout_4.addWidget(self.reload_btn, 1, 1, 1, 1)
        self.stockTable = QtWidgets.QTableWidget(self.stock_tab)
        font = QtGui.QFont()
        font.setPointSize(13)
        font.setBold(True)
        font.setWeight(75)
        self.stockTable.setFont(font)
        self.stockTable.setStyleSheet("QHeaderView::section {\n"
"    background-color: #002B5B;\n"
"    color: rgb(143, 227, 207);\n"
"    font: 12pt \"Kalpurush\";\n"
"}\n"
"\n"
"\n"
"\n"
"QTableWidget {\n"
"    background-color: #256D85;\n"
"    gridline-color: rgb(255, 255, 255);\n"
"    color: #fff;\n"
"}")
        self.stockTable.setVerticalScrollBarPolicy(QtCore.Qt.ScrollBarAsNeeded)
        self.stockTable.setObjectName("stockTable")
        self.stockTable.setColumnCount(3)
        self.stockTable.setRowCount(1)
        item = QtWidgets.QTableWidgetItem()
        self.stockTable.setVerticalHeaderItem(0, item)
        item = QtWidgets.QTableWidgetItem()
        self.stockTable.setHorizontalHeaderItem(0, item)
        item = QtWidgets.QTableWidgetItem()
        self.stockTable.setHorizontalHeaderItem(1, item)
        item = QtWidgets.QTableWidgetItem()
        self.stockTable.setHorizontalHeaderItem(2, item)
        item = QtWidgets.QTableWidgetItem()
        self.stockTable.setItem(0, 0, item)
        item = QtWidgets.QTableWidgetItem()
        self.stockTable.setItem(0, 1, item)
        item = QtWidgets.QTableWidgetItem()
        self.stockTable.setItem(0, 2, item)
        self.stockTable.horizontalHeader().setCascadingSectionResizes(True)
        self.stockTable.horizontalHeader().setDefaultSectionSize(180)
        self.stockTable.horizontalHeader().setSortIndicatorShown(True)
        self.stockTable.horizontalHeader().setStretchLastSection(True)
        self.stockTable.verticalHeader().setVisible(False)
        self.stockTable.verticalHeader().setCascadingSectionResizes(False)
        self.stockTable.verticalHeader().setHighlightSections(False)
        self.stockTable.verticalHeader().setSortIndicatorShown(False)
        self.stockTable.verticalHeader().setStretchLastSection(False)
        self.gridLayout_4.addWidget(self.stockTable, 0, 0, 1, 2)
        self.tabWidget.addTab(self.stock_tab, "")
        self.best_products_tab = QtWidgets.QWidget()
        self.best_products_tab.setObjectName("best_products_tab")
        self.gridLayout = QtWidgets.QGridLayout(self.best_products_tab)
        self.gridLayout.setObjectName("gridLayout")
        self.label = QtWidgets.QLabel(self.best_products_tab)
        font = QtGui.QFont()
        font.setPointSize(20)
        self.label.setFont(font)
        self.label.setObjectName("label")
        self.gridLayout.addWidget(self.label, 0, 0, 1, 1)
        spacerItem = QtWidgets.QSpacerItem(271, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout.addItem(spacerItem, 0, 1, 1, 1)
        self.product_count_edit = QtWidgets.QLineEdit(self.best_products_tab)
        self.product_count_edit.setMinimumSize(QtCore.QSize(400, 50))
        self.product_count_edit.setStyleSheet("background-color: rgb(224, 122, 95);\n"
"padding: 15px;\n"
"font: 15pt \"Kalpurush\";")
        self.product_count_edit.setText("")
        self.product_count_edit.setObjectName("product_count_edit")
        self.gridLayout.addWidget(self.product_count_edit, 0, 2, 1, 1)
        self.best_product_table = QtWidgets.QTableWidget(self.best_products_tab)
        self.best_product_table.setStyleSheet("background-color: rgb(0, 43, 91)")
        self.best_product_table.setObjectName("best_product_table")
        self.best_product_table.setColumnCount(2)
        self.best_product_table.setRowCount(0)
        item = QtWidgets.QTableWidgetItem()
        self.best_product_table.setHorizontalHeaderItem(0, item)
        item = QtWidgets.QTableWidgetItem()
        self.best_product_table.setHorizontalHeaderItem(1, item)
        self.best_product_table.horizontalHeader().setDefaultSectionSize(180)
        self.best_product_table.horizontalHeader().setStretchLastSection(True)
        self.best_product_table.verticalHeader().setCascadingSectionResizes(True)
        self.best_product_table.verticalHeader().setSortIndicatorShown(False)
        self.best_product_table.verticalHeader().setStretchLastSection(False)
        self.gridLayout.addWidget(self.best_product_table, 1, 0, 1, 3)
        self.tabWidget.addTab(self.best_products_tab, "")
        self.transaction_tab = QtWidgets.QWidget()
        self.transaction_tab.setObjectName("transaction_tab")
        self.gridLayout_2 = QtWidgets.QGridLayout(self.transaction_tab)
        self.gridLayout_2.setObjectName("gridLayout_2")
        spacerItem1 = QtWidgets.QSpacerItem(20, 92, QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Expanding)
        self.gridLayout_2.addItem(spacerItem1, 0, 2, 1, 1)
        spacerItem2 = QtWidgets.QSpacerItem(123, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout_2.addItem(spacerItem2, 1, 0, 1, 1)
        self.product_names_edit = QtWidgets.QLineEdit(self.transaction_tab)
        self.product_names_edit.setMinimumSize(QtCore.QSize(671, 101))
        self.product_names_edit.setStyleSheet("background-color: rgb(224, 122, 95);\n"
"padding: 15px;\n"
"font: 20pt \"Kalpurush\";")
        self.product_names_edit.setText("")
        self.product_names_edit.setObjectName("product_names_edit")
        self.gridLayout_2.addWidget(self.product_names_edit, 1, 1, 1, 3)
        spacerItem3 = QtWidgets.QSpacerItem(128, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout_2.addItem(spacerItem3, 1, 4, 1, 1)
        spacerItem4 = QtWidgets.QSpacerItem(123, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout_2.addItem(spacerItem4, 2, 0, 1, 1)
        self.product_quant_edit = QtWidgets.QLineEdit(self.transaction_tab)
        self.product_quant_edit.setMinimumSize(QtCore.QSize(671, 101))
        self.product_quant_edit.setMaximumSize(QtCore.QSize(671, 101))
        self.product_quant_edit.setStyleSheet("background-color: rgb(224, 122, 95);\n"
"padding: 15px;\n"
"font: 20pt \"Kalpurush\";")
        self.product_quant_edit.setText("")
        self.product_quant_edit.setObjectName("product_quant_edit")
        self.gridLayout_2.addWidget(self.product_quant_edit, 2, 1, 1, 3)
        spacerItem5 = QtWidgets.QSpacerItem(128, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout_2.addItem(spacerItem5, 2, 4, 1, 1)
        spacerItem6 = QtWidgets.QSpacerItem(20, 56, QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Expanding)
        self.gridLayout_2.addItem(spacerItem6, 3, 2, 1, 1)
        spacerItem7 = QtWidgets.QSpacerItem(308, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout_2.addItem(spacerItem7, 4, 0, 1, 2)
        self.add_transaction_btn = QtWidgets.QPushButton(self.transaction_tab)
        self.add_transaction_btn.setMinimumSize(QtCore.QSize(301, 51))
        self.add_transaction_btn.setMaximumSize(QtCore.QSize(301, 51))
        font = QtGui.QFont()
        font.setPointSize(13)
        self.add_transaction_btn.setFont(font)
        self.add_transaction_btn.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        self.add_transaction_btn.setStyleSheet("QPushButton {\n"
"background-color: rgb(0, 43, 91);\n"
"color:  white;\n"
"border-radius: 10px;\n"
"}\n"
"\n"
"QPushButton::hover:!pressed {\n"
"    \n"
"    background-color:  rgb(0, 29, 61);\n"
"    color: white;\n"
"\n"
"}")
        self.add_transaction_btn.setObjectName("add_transaction_btn")
        self.gridLayout_2.addWidget(self.add_transaction_btn, 4, 2, 1, 1)
        spacerItem8 = QtWidgets.QSpacerItem(313, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout_2.addItem(spacerItem8, 4, 3, 1, 2)
        spacerItem9 = QtWidgets.QSpacerItem(20, 72, QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Expanding)
        self.gridLayout_2.addItem(spacerItem9, 5, 2, 1, 1)
        self.tabWidget.addTab(self.transaction_tab, "")
        self.gridLayout_3.addWidget(self.tabWidget, 0, 1, 1, 1)
        MainWindow.setCentralWidget(self.centralwidget)

        self.retranslateUi(MainWindow)
        self.tabWidget.setCurrentIndex(0)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "MainWindow"))
        self.update_inventory_btn.setText(_translate("MainWindow", "Add Item in Inventory"))
        self.reload_btn.setText(_translate("MainWindow", "Reload Table"))
        self.stockTable.setSortingEnabled(True)
        item = self.stockTable.verticalHeaderItem(0)
        item.setText(_translate("MainWindow", "1"))
        item = self.stockTable.horizontalHeaderItem(0)
        item.setText(_translate("MainWindow", "Product"))
        item = self.stockTable.horizontalHeaderItem(1)
        item.setText(_translate("MainWindow", "Available Stock"))
        item = self.stockTable.horizontalHeaderItem(2)
        item.setText(_translate("MainWindow", "Purchase Possibility"))
        __sortingEnabled = self.stockTable.isSortingEnabled()
        self.stockTable.setSortingEnabled(False)
        item = self.stockTable.item(0, 0)
        item.setText(_translate("MainWindow", "Apple"))
        item = self.stockTable.item(0, 1)
        item.setText(_translate("MainWindow", "4"))
        item = self.stockTable.item(0, 2)
        item.setText(_translate("MainWindow", "20%"))
        self.stockTable.setSortingEnabled(__sortingEnabled)
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.stock_tab), _translate("MainWindow", "Stock"))
        self.label.setText(_translate("MainWindow", "Best Sold Product"))
        self.product_count_edit.setPlaceholderText(_translate("MainWindow", "eg. 2"))
        item = self.best_product_table.horizontalHeaderItem(0)
        item.setText(_translate("MainWindow", "Product Combinition"))
        item = self.best_product_table.horizontalHeaderItem(1)
        item.setText(_translate("MainWindow", "Confidence"))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.best_products_tab), _translate("MainWindow", "Best Products"))
        self.product_names_edit.setPlaceholderText(_translate("MainWindow", "Product Names (eg. Mango, Juice, )"))
        self.product_quant_edit.setPlaceholderText(_translate("MainWindow", "Product Amount (eg. 10,20)"))
        self.add_transaction_btn.setText(_translate("MainWindow", "Add Transaction"))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.transaction_tab), _translate("MainWindow", "Transaction"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Ui_MainWindow()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())
