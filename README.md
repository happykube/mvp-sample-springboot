# MVP Sample for Springboot

Springboot로 작성한 backend microservice 예제입니다.   
mysql과 연동하여 data를 CRUD하며, swagger page로 API를 테스트 할 수 있습니다.   

## 사전준비 
- [DBeaver](https://dbeaver.io/)를 설치합니다.  
- NFS Dynamic provisiong을 사용하려면, [NFS설치와 Dynamic provisiong설정](https://happycloud-lee.tistory.com/178?category=832243)을 참조하십시오.
- [run-cicd 파이프라인](https://happycloud-lee.tistory.com/195?category=832250) 다운로드
```
$ cd ~
$ git clone https://github.com/happyspringcloud/run-cicd.git
```

## mysql 설치
- k8s에 인증된 PC 또는 VM으로 접속합니다. 작업 OS id로 바꿉니다.   
```
$ su - {userid}
``` 

- 작업 디렉토리를 작성하고 이동합니다. 
```
$ mkdir -p ~/install/mysql
$ cd ~/install/mysql
``` 

- helm chart registry를 추가합니다. 
helm은 yum과 같은 프로그램 설치관리자이며 k8s에 리소스(pod, service 등)를 쉽게 배포해 줍니다.  
helm chart은 k8s 리소스 정의 파일들을 묶어 놓은것입니다.  
bitnami는 helm chart를 제공하는 회사명이며, 안정적인 helm chart를 제공하는 고마운 회사입니다.   
```
$ helm repo add bitnami https://charts.bitnami.com/bitnami
$ helm repo ls
$ helm repo update
```

- mysql chart의 위치를 찾습니다. 
아래 예에서는 bitnami/mysql	입니다.   
```
[hklee@bastion mysql]$ helm search repo mysql
NAME                   	CHART VERSION	APP VERSION	DESCRIPTION
bitnami/mysql          	8.5.1        	8.0.23     	Chart to create a Highly available MySQL cluster
bitnami/phpmyadmin     	8.2.4        	5.1.0      	phpMyAdmin is an mysql administration frontend
```
- mysql chart의 configuration 파일을 다운로드 합니다.  

```
$ helm inspect values bitnami/mysql > mysql.yaml

```

- 아래 예제를 참조하여 mysql.yaml을 수정합니다.  
쉽게 하려면, mysql.yaml을 다운로드하지 말고, 아래 내용으로 그냥 만드세요.   

storageClassName은 k get sc로 확인하시고, nodePort는 충돌안나게 지정하세요.  

```
## MySQL architecture. Allowed values: standalone or replication
architecture: replication

auth:
  rootPassword: "happy@cloud"
  database: sample
  username: "admin"
  password: "happy@cloud"
  ##
  replicationUser: replicator
  replicationPassword: "happy@cloud"

primary:
  persistence:
    enabled: true
    storageClass: "nfs-standard"
    accessModes:
      - ReadWriteOnce
    size: 8Gi

  service:
    type: NodePort
    port: 3306
    nodePort: 30001

secondary:
  replicaCount: 2
  persistence:
    enabled: true
    storageClass: "nfs-standard"
    accessModes:
      - ReadWriteOnce
    size: 8Gi
  service:
    type: NodePort
    port: 3306
    nodePort: 30002
```

- mysql을 배포합니다.   
```
$ kubens {본인 namespace} 
$ helm install mysql -f mysql.yaml bitnami/mysql --dry-run

위 명령 실행결과에 에러가 없으면 아래 명령으로 설치합니다.   
$ helm install mysql -f mysql.yaml bitnami/mysql
```

- 정상 동작 확인   
아래 명령으로 mysql-primary, mysql-secondary Pod들이 모두 Running 상태가 될때까지 기다립니다.    
모니터링을 중단하려면 CTRL-C를 누릅니다.    
```
$ kubectl get po -w 
```

# Database, Table 생성 
- DBeaver를 실행합니다. 
<img src="./img/2021-04-04-12-25-55.png" width=60% height=60%/>




