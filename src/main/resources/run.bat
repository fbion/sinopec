title sinopec server 
java -classpath . -Xms8096m -Xmx8096m -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDateStamps -XX:+PrintGCDetails  -Dfile.encoding=utf-8 -Djava.net.preferIPv4Stack=true -jar sinopec-release.jar