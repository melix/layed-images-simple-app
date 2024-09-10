# Layered images demo

This project demonstrates the new Layered Images support in `native-image`.
It consists of a single java application, which uses a single external dependency (Apache Commons Lang3).

## Prerequisites

1. Set the `JAVA_HOME` environment variable to a Java 21 JDK.
2. Set the `GRAALVM_HOME` environment variable to a build of GraalVM which supports layered images

## Test build

In order to test the setup, first run the build _without_ native image support:

`./gradlew -i nativeRun`

This will automatically:

- download the branch of [Native Build Tools](https://github.com/graalvm/native-build-tools/tree/cc/layered-images) which adds experimental support for layered images
- build it
- compile the native sample application _without_ layered images support
- run the binary

The output should be something similar to:

```
Configured http.cookieFile '/home/cchampeau/.gitcookies' is missing

> Configure project :native-build-tools:native-gradle-plugin
Test task functionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle7.4FunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle7.6.2FunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle8.0.1FunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle8.2.1FunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task configCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle7.4ConfigCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle7.6.2ConfigCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle8.0.1ConfigCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle8.2.1ConfigCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev

> Task :native-build-tools:aggregator:compileKotlin
w: file:///home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/checkouts/native-build-tools/build-logic/aggregator/src/main/kotlin/org.graalvm.build.aggregator.gradle.kts:93:62 'decapitalize(): String' is deprecated. Use replaceFirstChar instead.
w: file:///home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/checkouts/native-build-tools/build-logic/aggregator/src/main/kotlin/org/graalvm/build/tasks/GitReset.kt:60:37 'toLowerCase(): String' is deprecated. Use lowercase() instead.

> Task :native-build-tools:native-gradle-plugin:compileJava
Note: Some input files use or override a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
[native-image-plugin] Unable to find the GraalVM reachability metadata repository in Maven repository. Falling back to the default repository at https://github.com/oracle/graalvm-reachability-metadata/releases/download/0.3.8/graalvm-reachability-metadata-0.3.8.zip

> Task :nativeCompile
[native-image-plugin] Args are: [-cp, /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/libs/java-application.jar:/home/cchampeau/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-lang3/3.8.1/6505a72a097d9270f7a9e7bf42c4238283247755/commons-lang3-3.8.1.jar, --no-fallback, --verbose, -o, /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile/java-application, -H:ConfigurationFileDirectories=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/generated/generateResourcesConfigFile, org.graalvm.demo.Application]
[native-image-plugin] GraalVM Toolchain detection is disabled
[native-image-plugin] GraalVM location read from environment variable: GRAALVM_HOME
[native-image-plugin] Native Image executable path: /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/bin/native-image
Apply jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/thirdparty/native-image.properties
Apply jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/polyglot/native-image.properties
Executing [
HOME=/home/cchampeau \
LANG=en_US.UTF-8 \
LANGUAGE=en_US \
LC_ADDRESS=fr_FR.UTF-8 \
LC_CTYPE=en_US.UTF-8 \
LC_IDENTIFICATION=fr_FR.UTF-8 \
LC_MEASUREMENT=fr_FR.UTF-8 \
LC_MONETARY=fr_FR.UTF-8 \
LC_NAME=fr_FR.UTF-8 \
LC_NUMERIC=fr_FR.UTF-8 \
LC_PAPER=fr_FR.UTF-8 \
LC_TELEPHONE=fr_FR.UTF-8 \
PATH=/home/cchampeau/.nvm/versions/node/v21.7.2/bin:/home/cchampeau/bin:/home/cchampeau/.sdkman/candidates/java/21.0.4-graal/bin:/home/cchampeau/TOOLS/hub-linux-amd64-2.3.0-pre8/bin:/home/cchampeau/DEV/PROJECTS/GITHUB/gradle-profiler/build/install/gradle-profiler/bin:/home/cchampeau/.sdkman/candidates/quarkus/current/bin:/home/cchampeau/.sdkman/candidates/mvnd/current/bin:/home/cchampeau/.sdkman/candidates/micronaut/current/bin:/home/cchampeau/.sdkman/candidates/maven/current/bin:/home/cchampeau/.sdkman/candidates/kotlin/current/bin:/home/cchampeau/.sdkman/candidates/jbake/current/bin:/home/cchampeau/.sdkman/candidates/java/21.0.4-graal/bin:/home/cchampeau/.sdkman/candidates/groovy/current/bin:/home/cchampeau/.sdkman/candidates/gradleprofiler/current/bin:/home/cchampeau/.sdkman/candidates/gradle/current/bin:/home/cchampeau/.cargo/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/opt/go/bin:/home/cchampeau/go/bin:/home/cchampeau/DEV/PROJECTS/Oracle/mx:/home/cchampeau/TOOLS/apache-maven-3.5.3/bin:/snap/bin \
PWD=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile \
USE_NATIVE_IMAGE_JAVA_PLATFORM_MODULE_SYSTEM=true \
/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/bin/java \
-XX:+UseParallelGC \
-XX:+UnlockExperimentalVMOptions \
-XX:+EnableJVMCI \
-Dtruffle.TrustAllTruffleRuntimeProviders=true \
-Dtruffle.TruffleRuntime=com.oracle.truffle.api.impl.DefaultTruffleRuntime \
-Dgraalvm.ForcePolyglotInvalid=true \
-Dgraalvm.locatorDisabled=true \
-Dsubstratevm.HostLibC=glibc \
--add-exports=java.base/com.sun.crypto.provider=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.access=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.event=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.loader=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.logger=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.misc=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile,org.graalvm.nativeimage.pointsto \
--add-exports=java.base/jdk.internal.module=org.graalvm.nativeimage.base,org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.org.objectweb.asm=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.perf=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.platform=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.ref=org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=java.base/jdk.internal.reflect=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.util=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.vm.annotation=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.vm=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.invoke.util=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.net.www=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.net=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.nio.ch=org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=java.base/sun.reflect.annotation=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.factory=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.reflectiveObjects=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.repository=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.scope=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.tree=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.jca=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.provider=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.ssl=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.util=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.x509=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.text.spi=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.calendar=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.cldr=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.locale.provider=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.locale=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.resources=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util=org.graalvm.nativeimage.builder \
--add-exports=java.management/com.sun.jmx.mbeanserver=org.graalvm.nativeimage.builder \
--add-exports=java.management/sun.management=org.graalvm.nativeimage.builder,org.graalvm.nativeimage.pointsto \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.aarch64=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.amd64=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.site=com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.stack=jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile,org.graalvm.nativeimage.pointsto,org.graalvm.truffle.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.common=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.pointsto \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.aarch64=jdk.graal.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.amd64=jdk.graal.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.riscv64=jdk.graal.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot=com.oracle.graal.graal_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.meta=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.base,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile,org.graalvm.nativeimage.pointsto,org.graalvm.truffle.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.riscv64=com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.runtime=com.oracle.graal.graal_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.pointsto \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.services=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.events=org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.internal.event=org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.internal.jfc=com.oracle.svm.svm_enterprise,org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.internal=com.oracle.svm.svm_enterprise,org.graalvm.nativeimage.builder \
--add-exports=jdk.management/com.sun.management.internal=org.graalvm.nativeimage.builder \
-XX:-UseJVMCICompiler \
-Xss10m \
-XX:MaxRAMPercentage=30.07560018719357 \
-XX:GCTimeRatio=9 \
-XX:+ExitOnOutOfMemoryError \
-Djava.awt.headless=true \
'-Dorg.graalvm.vendor=GraalVM Community' \
-Dorg.graalvm.vendorurl=https://www.graalvm.org/ \
'-Dorg.graalvm.vendorversion=GraalVM CE 24-dev+12.1' \
-Dorg.graalvm.version=dev \
-Dcom.oracle.graalvm.isaot=true \
-Djava.system.class.loader=com.oracle.svm.hosted.NativeImageSystemClassLoader \
-Xshare:off \
-Djdk.reflect.useOldSerializableConstructor=true \
-Djdk.internal.lambda.disableEagerInitialization=true \
-Djdk.internal.lambda.eagerlyInitialize=false \
-Djava.lang.invoke.InnerClassLambdaMetafactory.initializeLambdas=false \
-Djava.lang.invoke.MethodHandle.DONT_INLINE_THRESHOLD=-1 \
-Djava.lang.invoke.MethodHandle.PROFILE_GWT=false \
--add-modules=ALL-DEFAULT \
--module-path \
/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-enterprise.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-runtime.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-api.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-compiler.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/builder/truffle-runtime-svm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/builder/truffle-enterprise-svm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/llvm-platform-specific-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/objectfile.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/javacpp-platform-specific-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-foreign.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-enterprise-ml-dataset.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/javacpp-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/native-image-base.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/llvm-wrapper-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-enterprise-llvm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-jdwp-common.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-enterprise.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/pointsto.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-jdwp-resident.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-llvm.jar \
--module \
org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGeneratorRunner \
-keepalive \
/proc/451715/comm \
-imagecp \
/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/libs/java-application.jar:/home/cchampeau/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-lang3/3.8.1/6505a72a097d9270f7a9e7bf42c4238283247755/commons-lang3-3.8.1.jar \
-imagemp \
/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/svm-graalos-support.jar \
-H:CLibraryPath=/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/clibraries/linux-amd64/glibc,/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/clibraries/linux-amd64,/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/clibraries \
-H:Path@driver=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile \
-H:FallbackThreshold@user+api=0 \
-H:Name@user+api=java-application \
-H:ConfigurationFileDirectories@user=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/generated/generateResourcesConfigFile \
'-H:Class@explicit main-class=org.graalvm.demo.Application' \
-H:ImageBuildID@driver=4952c524-832a-d8b1-de64-e5dc28e69de1 \
'-H:Features@jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/thirdparty/native-image.properties+api=com.oracle.svm.thirdparty.gson.GsonFeature' \
'-H:Features@jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/polyglot/native-image.properties+api=com.oracle.svm.polyglot.groovy.GroovyIndyInterfaceFeature,com.oracle.svm.polyglot.scala.ScalaFeature'
]
========================================================================================================================
GraalVM Native Image: Generating 'java-application' (executable)...
========================================================================================================================
For detailed information and explanations on the build output, visit:
https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
------------------------------------------------------------------------------------------------------------------------
[1/8] Initializing...                                                                                    (3.5s @ 0.16GB)
 Java version: 24+12, vendor version: GraalVM CE 24-dev+12.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3, PGO: ML-inferred
 C compiler: gcc (linux, x86_64, 11.4.0)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 1 user-specific feature(s):
 - com.oracle.svm.thirdparty.gson.GsonFeature
------------------------------------------------------------------------------------------------------------------------
Build resources:
 - 8.17GB of memory (26.7% of 30.56GB system memory, determined at start)
 - 16 thread(s) (100.0% of 16 available processor(s), determined at start)
[2/8] Performing analysis...  [*****]                                                                    (3.0s @ 0.22GB)
    2,062 reachable types   (56.4% of    3,658 total)
    1,803 reachable fields  (36.8% of    4,896 total)
    8,690 reachable methods (33.8% of   25,702 total)
      735 types,     5 fields, and    86 methods registered for reflection
       49 types,    34 fields, and    48 methods registered for JNI access
        4 native libraries: dl, pthread, rt, z
[3/8] Building universe...                                                                               (1.3s @ 0.33GB)
[4/8] Parsing methods...      [*]                                                                        (0.8s @ 0.26GB)
[5/8] Inlining methods...     [***]                                                                      (0.4s @ 0.26GB)
[6/8] Compiling methods...    [***]                                                                      (7.0s @ 0.48GB)
[7/8] Laying out methods...   [*]                                                                        (0.7s @ 0.27GB)
[8/8] Creating image...       [*]                                                                        (0.8s @ 0.33GB)
   2.86MB (41.34%) for code area:     3,901 compilation units
   3.38MB (48.79%) for image heap:   55,827 objects and 52 resources
 699.27kB ( 9.87%) for other data
   6.92MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
   1.32MB svm.jar (Native Image)                             707.09kB byte[] for java.lang.String
   1.27MB java.base                                          678.77kB byte[] for code metadata
  77.51kB com.oracle.svm.svm_enterprise                      368.77kB java.lang.String
  34.42kB jdk.proxy2                                         332.38kB java.lang.Class
  33.10kB org.graalvm.nativeimage.base                       277.45kB heap alignment
  26.06kB jdk.graal.compiler                                 184.63kB java.util.HashMap$Node
  25.64kB jdk.proxy1                                         114.52kB char[]
  22.48kB org.graalvm.collections                             96.66kB com.oracle.svm.core.hub.DynamicHubCompanion
  20.79kB jdk.internal.vm.ci                                  93.54kB java.lang.Object[]
   8.00kB jdk.proxy3                                          82.13kB byte[] for reflection metadata
   2.77kB for 6 more packages                                520.09kB for 536 more object types
                            Use '--emit build-report' to create a report with more details.
------------------------------------------------------------------------------------------------------------------------
Security report:
 - Binary includes Java deserialization.
 - Use '--enable-sbom' to assemble a Software Bill of Materials (SBOM).
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 G1GC: Use the G1 GC ('--gc=G1') for improved latency and throughput.
 PGO:  Use Profile-Guided Optimizations ('--pgo') for improved throughput.
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
 QBM:  Use the quick build mode ('-Ob') to speed up builds during development.
------------------------------------------------------------------------------------------------------------------------
                       1.0s (5.4% of total time) in 217 GCs | Peak RSS: 1.16GB | CPU load: 10.65
------------------------------------------------------------------------------------------------------------------------
Build artifacts:
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile/java-application (executable)
========================================================================================================================
Finished generating 'java-application' in 18.3s.
[native-image-plugin] Native Image written to: /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile

> Task :nativeRun
Hello, Native, I'm Using A Method From Commons-lang3!

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.8/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 54s
98 actionable tasks: 95 executed, 3 up-to-date
```

## Testing with layers

The next step is to build with layers enabled, by running:

`./gradlew -i nativeCompile --use-layers nativeRun`

This will:

1. compile the app with layers. 2 layers are created: one base layer which includes the JDK and the external dependencies, then the application layer.
2. run the app, automatically setting the `LD_LIBRARY_PATH` environment variable to reuse `.so` files

The output should be similar to this:

```
> Configure project :native-build-tools:native-gradle-plugin
Test task functionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle7.4FunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle7.6.2FunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle8.0.1FunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle8.2.1FunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task configCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle7.4ConfigCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle7.6.2ConfigCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle8.0.1ConfigCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
Test task gradle8.2.1ConfigCacheFunctionalTest will use GRAALVM_HOME = /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev
[native-image-plugin] Unable to find the GraalVM reachability metadata repository in Maven repository. Falling back to the default repository at https://github.com/oracle/graalvm-reachability-metadata/releases/download/0.3.8/graalvm-reachability-metadata-0.3.8.zip

> Task :createDependenciesLayer
[native-image-plugin] Args are: [-H:+UnlockExperimentalVMOptions, -H:LayerCreate=lib-base-image.nil,module=java.base,package=/home/cchampeau/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-lang3/3.8.1/6505a72a097d9270f7a9e7bf42c4238283247755/commons-lang3-3.8.1.jar, -cp, /home/cchampeau/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-lang3/3.8.1/6505a72a097d9270f7a9e7bf42c4238283247755/commons-lang3-3.8.1.jar, --no-fallback, --verbose, -o, /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/lib-base-image]
[native-image-plugin] GraalVM Toolchain detection is disabled
[native-image-plugin] GraalVM location read from environment variable: GRAALVM_HOME
[native-image-plugin] Native Image executable path: /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/bin/native-image
Apply jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/thirdparty/native-image.properties
Apply jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/polyglot/native-image.properties
Executing [
HOME=/home/cchampeau \
LANG=en_US.UTF-8 \
LANGUAGE=en_US \
LC_ADDRESS=fr_FR.UTF-8 \
LC_CTYPE=en_US.UTF-8 \
LC_IDENTIFICATION=fr_FR.UTF-8 \
LC_MEASUREMENT=fr_FR.UTF-8 \
LC_MONETARY=fr_FR.UTF-8 \
LC_NAME=fr_FR.UTF-8 \
LC_NUMERIC=fr_FR.UTF-8 \
LC_PAPER=fr_FR.UTF-8 \
LC_TELEPHONE=fr_FR.UTF-8 \
PATH=/home/cchampeau/.nvm/versions/node/v21.7.2/bin:/home/cchampeau/bin:/home/cchampeau/.sdkman/candidates/java/21.0.4-graal/bin:/home/cchampeau/TOOLS/hub-linux-amd64-2.3.0-pre8/bin:/home/cchampeau/DEV/PROJECTS/GITHUB/gradle-profiler/build/install/gradle-profiler/bin:/home/cchampeau/.sdkman/candidates/quarkus/current/bin:/home/cchampeau/.sdkman/candidates/mvnd/current/bin:/home/cchampeau/.sdkman/candidates/micronaut/current/bin:/home/cchampeau/.sdkman/candidates/maven/current/bin:/home/cchampeau/.sdkman/candidates/kotlin/current/bin:/home/cchampeau/.sdkman/candidates/jbake/current/bin:/home/cchampeau/.sdkman/candidates/java/21.0.4-graal/bin:/home/cchampeau/.sdkman/candidates/groovy/current/bin:/home/cchampeau/.sdkman/candidates/gradleprofiler/current/bin:/home/cchampeau/.sdkman/candidates/gradle/current/bin:/home/cchampeau/.cargo/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/opt/go/bin:/home/cchampeau/go/bin:/home/cchampeau/DEV/PROJECTS/Oracle/mx:/home/cchampeau/TOOLS/apache-maven-3.5.3/bin:/snap/bin \
PWD=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer \
USE_NATIVE_IMAGE_JAVA_PLATFORM_MODULE_SYSTEM=true \
/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/bin/java \
-XX:+UseParallelGC \
-XX:+UnlockExperimentalVMOptions \
-XX:+EnableJVMCI \
-Dtruffle.TrustAllTruffleRuntimeProviders=true \
-Dtruffle.TruffleRuntime=com.oracle.truffle.api.impl.DefaultTruffleRuntime \
-Dgraalvm.ForcePolyglotInvalid=true \
-Dgraalvm.locatorDisabled=true \
-Dsubstratevm.HostLibC=glibc \
--add-exports=java.base/com.sun.crypto.provider=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.access=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.event=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.loader=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.logger=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.misc=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile,org.graalvm.nativeimage.pointsto \
--add-exports=java.base/jdk.internal.module=org.graalvm.nativeimage.base,org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.org.objectweb.asm=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.perf=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.platform=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.ref=org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=java.base/jdk.internal.reflect=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.util=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.vm.annotation=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.vm=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.invoke.util=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.net.www=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.net=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.nio.ch=org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=java.base/sun.reflect.annotation=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.factory=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.reflectiveObjects=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.repository=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.scope=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.tree=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.jca=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.provider=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.ssl=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.util=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.x509=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.text.spi=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.calendar=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.cldr=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.locale.provider=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.locale=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.resources=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util=org.graalvm.nativeimage.builder \
--add-exports=java.management/com.sun.jmx.mbeanserver=org.graalvm.nativeimage.builder \
--add-exports=java.management/sun.management=org.graalvm.nativeimage.builder,org.graalvm.nativeimage.pointsto \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.aarch64=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.amd64=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.site=com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.stack=jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile,org.graalvm.nativeimage.pointsto,org.graalvm.truffle.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.common=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.pointsto \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.aarch64=jdk.graal.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.amd64=jdk.graal.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.riscv64=jdk.graal.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot=com.oracle.graal.graal_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.meta=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.base,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile,org.graalvm.nativeimage.pointsto,org.graalvm.truffle.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.riscv64=com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.runtime=com.oracle.graal.graal_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.pointsto \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.services=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.events=org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.internal.event=org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.internal.jfc=com.oracle.svm.svm_enterprise,org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.internal=com.oracle.svm.svm_enterprise,org.graalvm.nativeimage.builder \
--add-exports=jdk.management/com.sun.management.internal=org.graalvm.nativeimage.builder \
-XX:-UseJVMCICompiler \
-Xss10m \
-XX:MaxRAMPercentage=40.28487725377199 \
-XX:GCTimeRatio=9 \
-XX:+ExitOnOutOfMemoryError \
-Djava.awt.headless=true \
'-Dorg.graalvm.vendor=GraalVM Community' \
-Dorg.graalvm.vendorurl=https://www.graalvm.org/ \
'-Dorg.graalvm.vendorversion=GraalVM CE 24-dev+12.1' \
-Dorg.graalvm.version=dev \
-Dcom.oracle.graalvm.isaot=true \
-Djava.system.class.loader=com.oracle.svm.hosted.NativeImageSystemClassLoader \
-Xshare:off \
-Djdk.reflect.useOldSerializableConstructor=true \
-Djdk.internal.lambda.disableEagerInitialization=true \
-Djdk.internal.lambda.eagerlyInitialize=false \
-Djava.lang.invoke.InnerClassLambdaMetafactory.initializeLambdas=false \
-Djava.lang.invoke.MethodHandle.DONT_INLINE_THRESHOLD=-1 \
-Djava.lang.invoke.MethodHandle.PROFILE_GWT=false \
--add-modules=ALL-DEFAULT \
--module-path \
/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-enterprise.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-runtime.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-api.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-compiler.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/builder/truffle-runtime-svm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/builder/truffle-enterprise-svm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/llvm-platform-specific-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/objectfile.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/javacpp-platform-specific-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-foreign.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-enterprise-ml-dataset.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/javacpp-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/native-image-base.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/llvm-wrapper-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-enterprise-llvm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-jdwp-common.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-enterprise.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/pointsto.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-jdwp-resident.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-llvm.jar \
--module \
org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGeneratorRunner \
-keepalive \
/proc/461250/comm \
-imagecp \
/home/cchampeau/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-lang3/3.8.1/6505a72a097d9270f7a9e7bf42c4238283247755/commons-lang3-3.8.1.jar \
-imagemp \
/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/svm-graalos-support.jar \
-H:CLibraryPath=/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/clibraries/linux-amd64/glibc,/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/clibraries/linux-amd64,/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/clibraries \
-H:Path@driver=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer \
-H:+UnlockExperimentalVMOptions@user \
-H:LayerCreate@user=lib-base-image.nil,module=java.base,package=/home/cchampeau/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-lang3/3.8.1/6505a72a097d9270f7a9e7bf42c4238283247755/commons-lang3-3.8.1.jar \
-H:FallbackThreshold@user+api=0 \
-H:Name@user+api=lib-base-image \
-H:-UnlockExperimentalVMOptions@user \
-H:ImageBuildID@driver=32454feb-60ad-ed15-8722-3406d4e9b893 \
'-H:Features@jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/thirdparty/native-image.properties+api=com.oracle.svm.thirdparty.gson.GsonFeature' \
'-H:Features@jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/polyglot/native-image.properties+api=com.oracle.svm.polyglot.groovy.GroovyIndyInterfaceFeature,com.oracle.svm.polyglot.scala.ScalaFeature'
]
========================================================================================================================
GraalVM Native Image: Generating 'lib-base-image' (image layer)...
========================================================================================================================
For detailed information and explanations on the build output, visit:
https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
------------------------------------------------------------------------------------------------------------------------
[1/8] Initializing...                                                                                    (6.7s @ 0.25GB)
 Java version: 24+12, vendor version: GraalVM CE 24-dev+12.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3, PGO: ML-inferred
 C compiler: gcc (linux, x86_64, 11.4.0)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 1 user-specific feature(s):
 - com.oracle.svm.thirdparty.gson.GsonFeature
------------------------------------------------------------------------------------------------------------------------
 1 experimental option(s) unlocked:
 - '-H:LayerCreate' (origin(s): command line)
------------------------------------------------------------------------------------------------------------------------
Build resources:
 - 10.94GB of memory (35.8% of 30.56GB system memory, determined at start)
 - 16 thread(s) (100.0% of 16 available processor(s), determined at start)
[2/8] Performing analysis...  [************]                                                            (20.2s @ 3.94GB)
   19,485 reachable types   (83.1% of   23,434 total)
   60,682 reachable fields  (98.7% of   61,491 total)
  118,179 reachable methods (62.8% of  188,232 total)
    5,073 types,    15 fields, and 1,161 methods registered for reflection
       64 types,    73 fields, and    55 methods registered for JNI access
        4 native libraries: dl, pthread, rt, z
[3/8] Building universe...                                                                              (83.5s @ 6.65GB)
[4/8] Parsing methods...      [***]                                                                      (8.5s @ 7.07GB)
[5/8] Inlining methods...     [***]                                                                      (1.3s @ 7.45GB)
[6/8] Compiling methods...    [*****]                                                                   (31.8s @ 7.48GB)
[7/8] Laying out methods...   [***]                                                                      (6.6s @ 8.64GB)
Warning: The lambda method Lcom/sun/tools/javac/comp/ThisEscapeAnalyzer$$Lambda.0xbb487331d369c884997e8da9f2bd32681; might not have a stable name in the extension image.
Warning: The lambda method Lcom/sun/tools/javac/comp/ThisEscapeAnalyzer$$Lambda.0xbb487331d369c884997e8da9f2bd32682; might not have a stable name in the extension image.
[8/8] Creating image...       [***]                                                                     (10.1s @ 7.20GB)
  51.30MB (40.65%) for code area:    90,087 compilation units
  47.06MB (37.29%) for image heap:  620,208 objects and 170 resources
  27.85MB (22.06%) for other data
 126.21MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
  25.01MB java.base                                           14.94MB byte[] for code metadata
   5.45MB svm.jar (Native Image)                               7.68MB byte[] for java.lang.String
   5.38MB jdk.compiler                                         6.73MB java.lang.Class
   4.68MB java.desktop                                         4.30MB java.lang.String
   3.78MB java.xml                                             1.47MB char[]
   1.26MB commons-lang3-3.8.1.jar                              1.33MB byte[] for reflection metadata
 908.84kB jdk.jdeps                                            1.05MB int[]
 808.73kB jdk.jlink                                            1.04MB com.oracle.svm.core.hub.DynamicHubCompanion
 527.37kB jdk.jpackage                                       977.73kB byte[] for general heap data
 376.80kB java.security.jgss                                 854.81kB java.util.HashMap$Node
   2.53MB for 33 more packages                                 6.74MB for 4841 more object types
                            Use '--emit build-report' to create a report with more details.
------------------------------------------------------------------------------------------------------------------------
Security report:
 - Binary includes Java deserialization.
 - Use '--enable-sbom' to assemble a Software Bill of Materials (SBOM).
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 G1GC: Use the G1 GC ('--gc=G1') for improved latency and throughput.
 PGO:  Use Profile-Guided Optimizations ('--pgo') for improved throughput.
 AWT:  Use the tracing agent to collect metadata for AWT.
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
Native Image Layers: Layer written to lib-base-image.nil
------------------------------------------------------------------------------------------------------------------------
                      18.2s (6.8% of total time) in 2532 GCs | Peak RSS: 11.06GB | CPU load: 5.22
------------------------------------------------------------------------------------------------------------------------
Build artifacts:
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/graal_isolate.h (c_header)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/graal_isolate_dynamic.h (c_header)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/layer-snapshot-lib-base-image.json (layer_snapshot)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/lib-base-image.so (image_layer)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/libawt.so (jdk_library)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/libawt_headless.so (jdk_library)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/libawt_xawt.so (jdk_library)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/libfontmanager.so (jdk_library)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/libinstrument.so (jdk_library)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/libjava.so (jdk_library_shim)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/libjavajpeg.so (jdk_library)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/libjsound.so (jdk_library)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/libjvm.so (jdk_library_shim)
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/liblcms.so (jdk_library)
========================================================================================================================
Finished generating 'lib-base-image' in 4m 25s.
[native-image-plugin] Native Image written to: /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer

> Task :compileJava
Note: /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/src/main/java/org/graalvm/demo/Application.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.

> Task :generateResourcesConfigFile
[native-image-plugin] Resources configuration written into /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/generated/generateResourcesConfigFile/resource-config.json

> Task :nativeCompile
[native-image-plugin] Args are: [-H:+UnlockExperimentalVMOptions, -H:LayerUse=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/lib-base-image.nil, -cp, /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/libs/java-application.jar:/home/cchampeau/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-lang3/3.8.1/6505a72a097d9270f7a9e7bf42c4238283247755/commons-lang3-3.8.1.jar, --no-fallback, --verbose, -o, /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile/java-application, -H:ConfigurationFileDirectories=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/generated/generateResourcesConfigFile, org.graalvm.demo.Application]
[native-image-plugin] GraalVM Toolchain detection is disabled
[native-image-plugin] GraalVM location read from environment variable: GRAALVM_HOME
[native-image-plugin] Native Image executable path: /home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/bin/native-image
Apply jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/thirdparty/native-image.properties
Apply jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/polyglot/native-image.properties
Executing [
HOME=/home/cchampeau \
LANG=en_US.UTF-8 \
LANGUAGE=en_US \
LC_ADDRESS=fr_FR.UTF-8 \
LC_CTYPE=en_US.UTF-8 \
LC_IDENTIFICATION=fr_FR.UTF-8 \
LC_MEASUREMENT=fr_FR.UTF-8 \
LC_MONETARY=fr_FR.UTF-8 \
LC_NAME=fr_FR.UTF-8 \
LC_NUMERIC=fr_FR.UTF-8 \
LC_PAPER=fr_FR.UTF-8 \
LC_TELEPHONE=fr_FR.UTF-8 \
PATH=/home/cchampeau/.nvm/versions/node/v21.7.2/bin:/home/cchampeau/bin:/home/cchampeau/.sdkman/candidates/java/21.0.4-graal/bin:/home/cchampeau/TOOLS/hub-linux-amd64-2.3.0-pre8/bin:/home/cchampeau/DEV/PROJECTS/GITHUB/gradle-profiler/build/install/gradle-profiler/bin:/home/cchampeau/.sdkman/candidates/quarkus/current/bin:/home/cchampeau/.sdkman/candidates/mvnd/current/bin:/home/cchampeau/.sdkman/candidates/micronaut/current/bin:/home/cchampeau/.sdkman/candidates/maven/current/bin:/home/cchampeau/.sdkman/candidates/kotlin/current/bin:/home/cchampeau/.sdkman/candidates/jbake/current/bin:/home/cchampeau/.sdkman/candidates/java/21.0.4-graal/bin:/home/cchampeau/.sdkman/candidates/groovy/current/bin:/home/cchampeau/.sdkman/candidates/gradleprofiler/current/bin:/home/cchampeau/.sdkman/candidates/gradle/current/bin:/home/cchampeau/.cargo/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/opt/go/bin:/home/cchampeau/go/bin:/home/cchampeau/DEV/PROJECTS/Oracle/mx:/home/cchampeau/TOOLS/apache-maven-3.5.3/bin:/snap/bin \
PWD=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile \
USE_NATIVE_IMAGE_JAVA_PLATFORM_MODULE_SYSTEM=true \
/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/bin/java \
-XX:+UseParallelGC \
-XX:+UnlockExperimentalVMOptions \
-XX:+EnableJVMCI \
-Dtruffle.TrustAllTruffleRuntimeProviders=true \
-Dtruffle.TruffleRuntime=com.oracle.truffle.api.impl.DefaultTruffleRuntime \
-Dgraalvm.ForcePolyglotInvalid=true \
-Dgraalvm.locatorDisabled=true \
-Dsubstratevm.HostLibC=glibc \
--add-exports=java.base/com.sun.crypto.provider=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.access=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.event=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.loader=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.logger=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.misc=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile,org.graalvm.nativeimage.pointsto \
--add-exports=java.base/jdk.internal.module=org.graalvm.nativeimage.base,org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.org.objectweb.asm=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.perf=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.platform=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.ref=org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=java.base/jdk.internal.reflect=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.util=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.vm.annotation=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal.vm=org.graalvm.nativeimage.builder \
--add-exports=java.base/jdk.internal=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.invoke.util=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.net.www=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.net=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.nio.ch=org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=java.base/sun.reflect.annotation=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.factory=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.reflectiveObjects=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.repository=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.scope=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.reflect.generics.tree=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.jca=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.provider=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.ssl=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.util=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.security.x509=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.text.spi=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.calendar=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.cldr=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.locale.provider=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.locale=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util.resources=org.graalvm.nativeimage.builder \
--add-exports=java.base/sun.util=org.graalvm.nativeimage.builder \
--add-exports=java.management/com.sun.jmx.mbeanserver=org.graalvm.nativeimage.builder \
--add-exports=java.management/sun.management=org.graalvm.nativeimage.builder,org.graalvm.nativeimage.pointsto \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.aarch64=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.amd64=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.site=com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.stack=jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile,org.graalvm.nativeimage.pointsto,org.graalvm.truffle.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.common=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.pointsto \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.aarch64=jdk.graal.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.amd64=jdk.graal.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.riscv64=jdk.graal.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot=com.oracle.graal.graal_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.meta=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.base,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.objectfile,org.graalvm.nativeimage.pointsto,org.graalvm.truffle.compiler \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.riscv64=com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.runtime=com.oracle.graal.graal_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder,org.graalvm.nativeimage.pointsto \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.services=com.oracle.graal.graal_enterprise,com.oracle.svm.svm_enterprise,jdk.graal.compiler,org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.events=org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.internal.event=org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.internal.jfc=com.oracle.svm.svm_enterprise,org.graalvm.nativeimage.builder \
--add-exports=jdk.jfr/jdk.jfr.internal=com.oracle.svm.svm_enterprise,org.graalvm.nativeimage.builder \
--add-exports=jdk.management/com.sun.management.internal=org.graalvm.nativeimage.builder \
-XX:-UseJVMCICompiler \
-Xss10m \
-XX:MaxRAMPercentage=28.954610802526886 \
-XX:GCTimeRatio=9 \
-XX:+ExitOnOutOfMemoryError \
-Djava.awt.headless=true \
'-Dorg.graalvm.vendor=GraalVM Community' \
-Dorg.graalvm.vendorurl=https://www.graalvm.org/ \
'-Dorg.graalvm.vendorversion=GraalVM CE 24-dev+12.1' \
-Dorg.graalvm.version=dev \
-Dcom.oracle.graalvm.isaot=true \
-Djava.system.class.loader=com.oracle.svm.hosted.NativeImageSystemClassLoader \
-Xshare:off \
-Djdk.reflect.useOldSerializableConstructor=true \
-Djdk.internal.lambda.disableEagerInitialization=true \
-Djdk.internal.lambda.eagerlyInitialize=false \
-Djava.lang.invoke.InnerClassLambdaMetafactory.initializeLambdas=false \
-Djava.lang.invoke.MethodHandle.DONT_INLINE_THRESHOLD=-1 \
-Djava.lang.invoke.MethodHandle.PROFILE_GWT=false \
--add-modules=ALL-DEFAULT \
--module-path \
/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-enterprise.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-runtime.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-api.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/truffle-compiler.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/builder/truffle-runtime-svm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/truffle/builder/truffle-enterprise-svm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/llvm-platform-specific-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/objectfile.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/javacpp-platform-specific-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-foreign.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-enterprise-ml-dataset.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/javacpp-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/native-image-base.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/llvm-wrapper-shadowed.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-enterprise-llvm.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-jdwp-common.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-enterprise.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/pointsto.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-jdwp-resident.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/builder/svm-llvm.jar \
--module \
org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGeneratorRunner \
-keepalive \
/proc/462275/comm \
-imagecp \
/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/libs/java-application.jar:/home/cchampeau/.gradle/caches/modules-2/files-2.1/org.apache.commons/commons-lang3/3.8.1/6505a72a097d9270f7a9e7bf42c4238283247755/commons-lang3-3.8.1.jar \
-imagemp \
/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar:/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/svm-graalos-support.jar \
-H:CLibraryPath=/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/clibraries/linux-amd64/glibc,/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/clibraries/linux-amd64,/home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/clibraries \
-H:Path@driver=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile \
-H:+UnlockExperimentalVMOptions@user \
-H:LayerUse@user=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/createDependenciesLayer/lib-base-image.nil \
-H:FallbackThreshold@user+api=0 \
-H:Name@user+api=java-application \
-H:ConfigurationFileDirectories@user=/home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/generated/generateResourcesConfigFile \
-H:-UnlockExperimentalVMOptions@user \
'-H:Class@explicit main-class=org.graalvm.demo.Application' \
-H:ImageBuildID@driver=455fe944-51fb-707e-898e-e11e3a5aa94f \
'-H:Features@jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/thirdparty/native-image.properties+api=com.oracle.svm.thirdparty.gson.GsonFeature' \
'-H:Features@jar:file:///home/cchampeau/DEV/PROJECTS/Oracle/graal/sdk/mxbuild/linux-amd64/GRAALVM_271E73BFC8_JAVA24/graalvm-271e73bfc8-java24-24.2.0-dev/lib/svm/library-support.jar!/META-INF/native-image/com.oracle.svm/polyglot/native-image.properties+api=com.oracle.svm.polyglot.groovy.GroovyIndyInterfaceFeature,com.oracle.svm.polyglot.scala.ScalaFeature'
]
========================================================================================================================
GraalVM Native Image: Generating 'java-application' (executable)...
========================================================================================================================
For detailed information and explanations on the build output, visit:
https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
------------------------------------------------------------------------------------------------------------------------
Native Image Layers: Loaded layer from lib-base-image.nil
Native Image Layers: Layer created at 'Tuesday, September 10, 2024, 12:37:34 PM Central European Summer Time'
Native Image Layers: Using version: '24+12-jvmci-b01' (vendor 'GraalVM Community') on platform: 'linux-amd64'
[1/8] Initializing...                                                                                    (3.8s @ 6.03GB)
 Java version: 24+12, vendor version: GraalVM CE 24-dev+12.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3, PGO: ML-inferred
 C compiler: gcc (linux, x86_64, 11.4.0)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 1 user-specific feature(s):
 - com.oracle.svm.thirdparty.gson.GsonFeature
------------------------------------------------------------------------------------------------------------------------
 1 experimental option(s) unlocked:
 - '-H:LayerUse' (origin(s): command line)
------------------------------------------------------------------------------------------------------------------------
Build resources:
 - 7.87GB of memory (25.7% of 30.56GB system memory, determined at start)
 - 16 thread(s) (100.0% of 16 available processor(s), determined at start)
[2/8] Performing analysis...  [************]                                                            (22.5s @ 6.11GB)
GC warning: 15.3s spent in 24 GCs during the last stage, taking up 66.89% of the time.
            Please ensure more than 7.21GB of memory is available for Native Image
            to reduce GC overhead and improve image build time.
       10 reachable types   ( 0.1% of   12,951 total)
        2 reachable fields  ( 0.0% of   37,971 total)
    1,778 reachable methods ( 1.5% of  121,670 total)
    3,331 types,     2 fields, and   591 methods registered for reflection
       64 types,    73 fields, and    55 methods registered for JNI access
        5 native libraries: -base-image, dl, pthread, rt, z
[3/8] Building universe...                                                                              (17.9s @ 6.19GB)
GC warning: 15.7s spent in 22 GCs during the last stage, taking up 87.58% of the time.
            Please ensure more than 7.25GB of memory is available for Native Image
            to reduce GC overhead and improve image build time.
[4/8] Parsing methods...      [*]                                                                        (1.3s @ 6.13GB)
[5/8] Inlining methods...     [*]                                                                        (0.0s @ 6.13GB)
[6/8] Compiling methods...    [**]                                                                       (3.2s @ 6.10GB)
[7/8] Laying out methods...   [*]                                                                        (0.5s @ 6.12GB)
[8/8] Creating image...       [**]                                                                       (2.2s @ 6.23GB)
 385.14kB (12.77%) for code area:     1,764 compilation units
   1.94MB (65.79%) for image heap:   24,104 objects and 167 resources
 646.41kB (21.44%) for other data
   2.94MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
 359.88kB java.base                                          918.54kB heap alignment
   3.72kB svm.jar (Native Image)                             169.88kB byte[] for java.lang.String
  190.00B java-application.jar                               144.73kB java.lang.Object[]
   67.00B java.xml                                           125.25kB java.util.HashMap$Node
                                                             120.95kB byte[] for code metadata
                                                              79.13kB com.oracle.svm.core.configure.RuntimeConditionSet
                                                              78.07kB c.o.svm.core.configure.ConditionalRuntimeValue
                                                              66.93kB java.util.HashMap$Node[]
                                                              61.99kB java.lang.String
                                                              42.23kB java.util.HashMap
    0.00B for 0 more packages                                176.31kB for 86 more object types
                            Use '--emit build-report' to create a report with more details.
------------------------------------------------------------------------------------------------------------------------
Security report:
 - Binary includes Java deserialization.
 - Use '--enable-sbom' to assemble a Software Bill of Materials (SBOM).
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 G1GC: Use the G1 GC ('--gc=G1') for improved latency and throughput.
 PGO:  Use Profile-Guided Optimizations ('--pgo') for improved throughput.
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
 QBM:  Use the quick build mode ('-Ob') to speed up builds during development.
------------------------------------------------------------------------------------------------------------------------
                       37.9s (28.1% of total time) in 524 GCs | Peak RSS: 7.30GB | CPU load: 4.60
------------------------------------------------------------------------------------------------------------------------
Build artifacts:
 /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile/java-application (executable)
========================================================================================================================
Finished generating 'java-application' in 2m 14s.
[native-image-plugin] Native Image written to: /home/cchampeau/DEV/PROJECTS/Oracle/test-projects/java-application/build/native/nativeCompile

> Task :nativeRun
Hello, Native, I'm Using A Method From Commons-lang3!

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.8/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 6m 53s
```

## Updating the sources

It is now possible to edit the `src/main/java/org/graaalvm/demo/Application.java` file, for example by adding a `println` statement, then run the app again:

`./gradlew -i nativeCompile --use-layers nativeRun`

This will show that the application is recompiled, but the base image will _not_ be rebuilt, only the application layer.
