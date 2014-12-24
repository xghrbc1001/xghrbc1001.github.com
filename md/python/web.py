#!/usr/bin/python
import SimpleHTTPServer
import SocketServer
import os

PORT = 7777 
WEBDIR = "/data/beni/dbscripts/web"

class Handler(SimpleHTTPServer.SimpleHTTPRequestHandler):
    def translate_path(self, path):
        os.chdir(WEBDIR)
        return SimpleHTTPServer.SimpleHTTPRequestHandler.translate_path(self,path)

try:
    httpd = SocketServer.TCPServer(("", PORT), Handler)
    print "dir %s serving at port %s"%(repr(WEBDIR), PORT)
    httpd.serve_forever()
except:pass
