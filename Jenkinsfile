pipeline {
    agent any

    environment {
        DOCKERFILE_PATH = '/Dockerfile'
        DOCKER_IMAGE_NAME = 'jashwanthraj/backend'
        registry='jashwanthraj/backend'
        DOCKER_REGISTRY_CREDENTIALS = 'docker'
        KUBECONFIG = '/home/Jenkins/.kube/config'
    }

    stages {
        stage("Build a JAR File") {
            steps {
                script {
                    checkout scm
                    sh 'mvn clean package'
                }
            }
        }
        stage("Build a Docker Image") {
            steps {
                script {
                    // Set DOCKER_BUILDKIT environment variable to enable BuildKit
                    def customImage =docker.build("${DOCKER_IMAGE_NAME}:${env.BUILD_NUMBER}")


                }
            }
        }
        stage("Push the Docker Image to Docker Hub") {
            steps {
                script {
                    docker.withRegistry('', "${DOCKER_REGISTRY_CREDENTIALS}") {
                        docker.image("${DOCKER_IMAGE_NAME}:${env.BUILD_NUMBER}").push()
                    }
                }
            }
        }
        stage ("Deploying Image as a Single Node to Rancher") {
            steps {
                script {
                    sh"kubectl config current-context"
                    sh "kubectl set image deployment/hw3backend container-0=${DOCKER_IMAGE_NAME}:${env.BUILD_NUMBER} "
                }
            }
        }
        stage("Deploying Load Balancer in Rancher") {
            steps {
                script {
                    sh "kubectl set image deployment/loadbalancer container-0=${DOCKER_IMAGE_NAME}:${env.BUILD_NUMBER} "

                }
            }
        }
    }
}
