pipeline {
    agent any
    tools {
    maven 'Maven'
    }
    
   
    stages {
        stage('Checkout') {
            steps {
                
                checkout scm
            }
        }

      
        stage('Build') {
            steps {
           
                bat 'mvn clean package'
            }
        }
        
        // stage('Test') {
        //     steps {
               
        //         sh 'mvn test'
        //     }
            
        //     post {
                
        //         always {
        //             junit '**/target/surefire-reports/*.xml'
        //         }
        //     }
        // }
        
        // stage('Deploy') {
        //     steps {
        //         // Deploy the application (example: copying artifacts to a server)
        //         sh 'scp target/*.jar user@server:/path/to/deployment/'
        //     }
        // }
        
        stage('Clean Up') {
            steps {
              
                bat 'rm -rf target'
            }
        }
    }
      // triggers {
      //       pollSCM('* * * * *')
      //   }

}