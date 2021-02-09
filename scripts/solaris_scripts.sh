export JAVA_HOME=/usr/jdk/instances/jdk1.8.0_181
export PATH=${PATH}:${JAVA_HOME}/bin

ln -s instances/jdk1.8.0_181 jdk1.8.0

JAVA_HOME=/usr/jdk/instances/jdk1.8.0_181
export JAVA_HOME

java -cp out/artifacts/huim_aco_jar/huim-aco.jar com.maths.huim.driver

scp huim-aco/out/artifacts/huim_aco_jar/huim-aco.jar  root@10.57.5.141:/Documents/huim-aco/out/artifacts/huim_aco_jar

/home/arnab/huim-aco/data/connect_utility_spmf/transactions.txt

scp -r spmf/out/artifacts/spmf_jar root@10.57.5.141:/Documents/
scp -r spmf/out/artifacts/spmf_jar/spmf.jar root@10.57.5.141:/Documents/spmf_jar/
java -jar spmf.jar