# Expense Tracker API
A simple CRUD API built with **Spring Boot**, utilizing AWS services such as RDS **PostgreSQL**, **Elastic Container Registry** (ECR), and **Elastic Kubernetes Service** (EKS) for deployment.

### Add expense
![img.png](ss/img.png)
### Get all expenses
![img.png](ss/img1.png)
### Get expense by id
![img.png](ss/img2.png)
### Update expense
![img.png](ss/img3.png)
### Delete expense
![img.png](ss/img4.png)

---

### How to run locally:
1. Clone this repository.
2. Set up PostgreSQL database.
    ```shell
    CREATE DATABASE postgres;
    
    CREATE TABLE expenses (
        id SERIAL PRIMARY KEY,
        expense VARCHAR(120) NOT NULL,
        cost float NOT NULL	
    );
    ```
3. Install dependencies.
    ```shell
   # using maven
    mvn clean install
    ```
4. Run the application.
    ```shell
    java -jar target/expense-tracker-0.0.1-SNAPSHOT.jar
    ```

