
```markdown
# SWE 645 - Microservices-based Application for Student Survey Management

## Team Members
- **Jashwanth Raj Gowlikar** (G01356160)



**Note**: Try accessing the links of the webpages using Google Chrome as Safari may redirect to HTTPS even after editing the link to HTTP.


## Creating an RDS Database
1. Go to AWS Management Console and search for RDS.
2. Go to Databases and click on "Create Database".
3. Click on "Easy Create" and select MySQL as the database.
4. Select the free tier or based on your requirements.
5. Provide the database name, master username, and select “self-managed” as credentials management.
6. Create the password for the database and click on "Create Database".
7. Ensure the RDS Database is public and the security group allows all TCP, HTTP, HTTPS, and SSH traffic.

## Creating a Spring Boot Application
1. Use Spring Initializer to create a Spring Boot project with dependencies: Spring Web, Spring Data JPA, and MySQL Driver.
2. Download the project and open it in your IDE (e.g., IntelliJ IDEA).
3. Under `src/main/resources`, open `application.properties` and enter the following properties:
   ```properties
   spring.datasource.url=jdbc:mysql://database-1.cna28eww0az5.us-east-1.rds.amazonaws.com:3306/yourdbname
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
   ```

4. Create the following packages in the `main/java` folder:
   - `controller`
   - `exception`
   - `model`
   - `repository`
   - `service`
   - `service/impl`

5. Create the necessary classes in each package to handle the application logic.
6. Define methods in the controller class for different HTTP methods with appropriate annotations.
7. Create a class with `@Entity` annotation under the model package for the JPA entity.
8. Test the application by running the main class, usually deployed at `http://localhost:8080/api/students`.
9. Create a JAR file using:
   ```bash
   mvn clean package
   ```

## Testing the Application using Postman
1. Download and run Postman.
2. Enter the URL of the application (e.g., `http://localhost:8080/api/students`) and select the operation (GET, POST, PUT, DELETE).
3. Ensure the application is running before testing with Postman.
4. For POST and PUT operations, enter the data in JSON format in the request body.
5. For GET, PUT, and DELETE operations, include the record ID in the URL (e.g., `http://localhost:8080/api/students/1`).

## Steps to Create a Docker Image and Push it to Docker Hub
1. Install Docker on your system:
   ```bash
   sudo apt-get install docker.io
   ```

2. Convert your project to a JAR file:
   ```bash
   mvn clean package
   ```

3. Create a `Dockerfile` with the following content:
   ```dockerfile
   FROM openjdk:11
   EXPOSE 8080
   ADD target/demo-0.0.1-SNAPSHOT.jar demo.jar
   ENTRYPOINT ["java", "-jar", "/demo.jar"]
   ```

4. Build the Docker image:
   ```bash
   docker build -t jashwanthraj/backend:1.0 .
   ```

5. Run the Docker container:
   ```bash
   docker run -it -p 8888:8080 jashwanthraj/backend:1.0
   ```

6. Open your browser and go to `localhost:8888/api/students`.
7. Push the Docker image to Docker Hub:
   ```bash
   docker login -u <docker_username>
   docker push jashwanthraj/backend:1.0
   ```

## Creating a Rancher Server on AWS
1. Go to your AWS dashboard and search for EC2.
2. Create two EC2 instances: one as `rancher-server` and the other as `worker` with the same configurations.
3. Ensure the security group allows HTTP (port 80), HTTPS (port 443), SSH (port 22), and custom TCP (port 8080).
4. Create two Elastic IP addresses and associate them with the Rancher and Worker instances.
5. Connect to the instances using "EC2 Instance Connect".
6. Install Docker on both instances:
   ```bash
   sudo apt install docker.io
   docker -v
   sudo usermod -aG docker ubuntu
   ```

7. On the Rancher EC2 instance, start Rancher:
   ```bash
   sudo docker run --privileged -d --restart=unless-stopped -p 80:80 -p 443:443 rancher/rancher
   ```

8. Go to the public IP address of the Rancher EC2 instance to launch Rancher.
9. Follow the on-screen instructions to get the password and log in to Rancher.
10. Create a Kubernetes cluster (RKE1) and register the worker node.
11. Deploy the Docker image on the cluster by creating a deployment and load balancer.

## Creating a CI/CD Pipeline using Git and Jenkins
1. Create a Git repository and upload your files (Dockerfile, index.html, .war file).
2. Launch a new EC2 instance and install Docker.
3. Install Jenkins on the instance:
   ```bash
   sudo apt install fontconfig openjdk-17-jre
   sudo wget -O /usr/share/keyrings/jenkins-keyring.asc https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
   echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null
   sudo apt-get update
   sudo apt-get install jenkins
   ```

4. Check Jenkins status:
   ```bash
   sudo systemctl status jenkins
   ```

5. Access Jenkins at `localhost:8080`.
6. Get the initial admin password:
   ```bash
   sudo cat /var/lib/jenkins/secrets/initialAdminPassword
   ```

7. Install kubectl:
   ```bash
   sudo snap install kubectl --classic
   ```

8. Configure kubeconfig by copying the Rancher kubeconfig.
9. Verify kubectl:
   ```bash
   kubectl config current-context
   ```

10. Add GitHub and Docker credentials in Jenkins.
11. Install necessary Jenkins plugins: Docker, Docker Pipeline, Docker API, and CloudBees Docker.
12. Create a Jenkinsfile in VS Code with the pipeline details and upload it to GitHub.
13. Create a new Jenkins job and configure it to poll SCM and use the pipeline from the Git repository.
14. Trigger the build by making changes to the Git files.

## Checking the Application with Postman
1. Verify if the application is running by testing the endpoints with Postman.
