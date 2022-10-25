SUMMARY = "A custom image for the reTerminal boards"
HOMEPAGE = "https://www.seeedstudio.com/"

require recipes-core/images/core-image-minimal.bb
#inherit image

#IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

DISTRO_FEATURES:append = " wifi "

CORE_OS = "\
    firewall \
	openssh-sftp-server \
	openssh \ 
	openssl \
"

KERNEL_EXTRA = "\
    kernel-modules \
	linux-firmware-rpidistro-bcm43430 \
"

TOOLS_EXTRA = "\
	bash \
	nano \
	curl \
	dotnet-scripts \
	i2c-tools \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${KERNEL_EXTRA} \
    ${TOOLS_EXTRA} \
"

#export IMAGE_BASENAME = "core-image-minimal"