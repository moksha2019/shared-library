// we can  write the   pipeline  and groovy code as well here
// we need to import the class from com.prasadacademy.builds

import com.prasadacademy.builds.Calculator

def call (Map pipelineparams){
    Calculator calculator = new Calculator(this)
    
    pipeline {
        agent any
        environemnt {
            APP_NAME = "${pipelineparams.appName}" // this value  should be  coming  from microservices jenkinfile
        }
        stages {
            stage ('Addition stage'){
                steps {
                    script {
                        echo "printing  the sum of 2 numbers"
                        println Calculator.add(3,1) // add excepts two numbers
                        echo "************** Microservice name is ${APP_NAME}"
                    }
                }
            }
            stage('second stage'){
                steps {
                    echo "Printing the  second stage: "
                }
            }
        }
    }

}