set -xe

# Design System
echo "Building artifacts for com.globe.designsystem:designsystem"

cd "reimagined"
gradle clean
gradle build
gradle publishToMavenLocal

#Run this to skip tests when publishing
#gradle clean
#gradle build -x test
#gradle publishToMavenLocal -x test

