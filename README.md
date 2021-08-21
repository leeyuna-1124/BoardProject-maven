# BoardProject
게시판
Java
MyBatis+Mysql+SpringBoot+Maven

테이블 구조

-board  
| Column Name  | DataType    | Condition               |
|--------------|-------------|-------------------------|
| boardIdx(pk) | int         | NOT NULL AUTO_INCREMENT |
| title        | varchar(45) | DEFAULT NULL            |
| content      | varchar(45) | DEFAULT NULL            |
| regDate      | date        | DEFAULT NULL            |

