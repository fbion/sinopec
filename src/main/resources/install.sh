#!/bin/sh
sudo unzip -oq sinopec-release-final.zip  -d /home/sinopec-release-final
sudo chmod +x /home/sinopec-release-final/* -R


count=`uname  -v  | grep  Ubuntu  |grep -v "grep"  |wc -l` 
if [ $count -eq 0 ] 
  then
    # chkconfig: 345 64 36
    # description: Sinopec  Server.
	sudo cp -f sinopec  /etc/rc.d/init.d/
	sed -i '/#!\/bin\/sh/a\# chkconfig: 345 64 36\n# description: Sinopec  Server.' /etc/rc.d/init.d/sinopec 
	sudo chmod +x /etc/rc.d/init.d/sinopec
	sudo chkconfig --add sinopec
	
  else
    sudo cp -f sinopec /etc/init.d/
	### BEGIN INIT INFO
	# Provides:          sinopec
	# Required-Start:    $remote_fs
	# Required-Stop:     $remote_fs
	# Default-Start:     2 3 4 5
	# Default-Stop:      0 1 6
	# Short-Description: Start or stop the sinopec service.
	### END INIT INFO
	sed -i '/#!\/bin\/sh/a\### BEGIN INIT INFO\n# Provides: sinopec\n# Required-Start:$remote_fs\n# Required-Stop:$remote_fs\n# Default-Start: 2 3 4 5\n# Default-Stop: 0 1 6\n# Short-Description: Start or stop the sinopec service.\n### END INIT INFO' /etc/init.d/sinopec
    sudo chmod +x /etc/init.d/sinopec
	sudo update-rc.d sinopec defaults
fi

service sinopec start 
