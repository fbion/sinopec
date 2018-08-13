#!/bin/sh
sudo unzip -oq sinopec-release-final.zip  -d /home/sinopec-release-final
sudo chmod +x /home/sinopec-release-final/* -R
sudo cp -f sinopec /etc/rc.d/init.d/
sudo chmod +x /etc/rc.d/init.d/sinopec
sudo chkconfig --add sinopec
service sinopec start 
