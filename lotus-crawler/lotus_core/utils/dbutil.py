# -*- coding: utf-8 -*-

import pymysql
from DBUtils import PooledDB

__mysql_connection_pool = None
host = '127.0.0.1'
port = 3306
user = 'root'
password = 'ipampas'
db = 'stock'


def get_connection():
    global __mysql_connection_pool
    if not __mysql_connection_pool:
        __mysql_connection_pool = PooledDB.PooledDB(pymysql, mincached=10, maxcached=100,
                                                    maxconnections=200, blocking=True, host=host, port=port,
                                                    user=user, passwd=password, db=db)
    return __mysql_connection_pool.connection()
