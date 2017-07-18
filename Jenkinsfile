node {
    try {
        stage('Stage Checkout') {
            checkout scm
            echo "My branch is: ${env.BRANCH_NAME}"
        }
        stage('Stage Build') {
            sh "mvn clean deploy -Dmaven.test.skip=true -U"
        }
        stage('Stage Archive') {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
    catch (err) {
        currentBuild.result = "FAILED"
        notifyFailed(err)
        throw err
    }
//    def sonProject = 'Multibranch-business-logic-core'
//    def branchName = getBranchName("${env.BRANCH_NAME}")
//    try {
//        stage('Build other project') {
//
//            build "${sonProject}/${branchName}"
//        }
//    }
//    catch (err) {
//        flag = true
//        echo "触发下级工程有问题:${sonProject}/${branchName}"
//        mail body: "触发下级工程有问题:${sonProject}/${branchName} \n ${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - : \n Check console output at ${env.BUILD_URL} to view the results.\nERROR:\n ${err}",
////                from: 'jenkins@cheok.com',
//                replyTo: 'jenkins@cheok.com',
//                subject: "触发下级工程有问题:${sonProject}/${branchName}",
//                to: 'scm@cheok.com'
//        echo "${err}"
//    }
}

def notifyFailed(def err) {
    emailext(
            subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}] [${env.BRANCH_NAME}]'",
            body: """FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}] [${env.BRANCH_NAME}]':
Check console output at ${env.BUILD_URL}
ERROR:
${err}
""",
            recipientProviders: [[$class: 'CulpritsRecipientProvider'], [$class: 'RequesterRecipientProvider']],
            to: 'scm@cheok.com'
    )
}

//分支中带/符号,需要urlencode
def static getBranchName(String branch) {
    return branch.replace('/', '%2F')
}