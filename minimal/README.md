# scalajslambda

Demonstration project for the use of ScalaJS for AWS Lambda functions

## usage:

you need: 
* aws sam cli 
* sbt 

### clone:
`git clone https://github.com/schneist/scalajslambda.git`

### build:

create javascript:
`sbt fullOptJS`

copy to js folder
`sbt copyRes`

build sam app
`sam build --template hello-world/template.yml --build-dir hello-world/.aws-sam/build`

package sam app
`sam package --template-file hello-world/.aws-sam/build/template.yaml --output-template-file hello-world/.aws-sam/build/packaged-template.yaml --s3-bucket `

deploy sam app
`sam deploy --template-file hello-world/.aws-sam/build/packaged-template.yaml --stack-name $$YOUR_STACK_NAME$$ --s3-bucket $$YOUR_BUCKET$$ --capabilities CAPABILITY_IAM CAPABILITY_NAMED_IAM `