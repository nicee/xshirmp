# -*- coding: utf-8 -*-
import pymysql


def connector():
    username = 'root'
    password = 'ipampas'
    database = 'sys'

    return pymysql.connect("127.0.0.1", username, password, database)
