# Database環境（MySQL立ち上げ）
DockerでMySQLの環境を作っていることを前提とする。  
環境構築未実施の場合は[こちら](https://github.com/mashio08/mysql_docker "こちら")を参照のこと。
* dockerコンテナの確認  
`docker ps -a`
* dockerの起動  
`docker start {対象のコンテナID}`
* mysqlの起動（rootとパスは適宜変更を）  
`mysql -u root -proot -h 127.0.0.1`

# Database環境（DB設定）
* DB作成  
`CREATE DATABASE vader`
* DB切替  
`USE vader`
* DDLを流す  
`source src/main/resources/sql/ddl/chat.sql`  
`source src/main/resources/sql/ddl/game.sql`  
`source src/main/resources/sql/ddl/game_progress.sql`  
`source src/main/resources/sql/ddl/game_user.sql`  
`source src/main/resources/sql/ddl/room.sql`  
* DMLを流す  
`source src/main/resources/sql/dml/game.sql`  

# 動作確認
Applicationを実行して http://localhost:8080/v1/game/  で確認。