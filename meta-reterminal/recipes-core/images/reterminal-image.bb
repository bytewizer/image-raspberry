SUMMARY = "A custom image for the reterminal boards"
HOMEPAGE = "https://www.seeedstudio.com/"

require recipes-core/images/core-image-minimal.bb
#inherit image

#IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

DISTRO_FEATURES:append = " wifi "
IMAGE_INSTALL:append = " linux-firmware-rpidistro-bcm43430 "

CORE_OS = "\
    firewall \
	openssh-sftp-server \
	openssh \ 
	openssl \ 
"

KERNEL_EXTRA = "\
    kernel-modules \
"

TOOLS_EXTRA = "\
	nano \
	curl \
	i2c-tools \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${KERNEL_EXTRA} \
    ${TOOLS_EXTRA} \
"

# IMAGE_INSTALL:append = " \
# 		kernel-modules \
# 		seeed-linux-dtoverlays \
# 		openssh-sftp-server\
# 		openssh \
# 		openssl \
#         i2c-tools \
# 		nano \
# 		curl \
# 	"

#export IMAGE_BASENAME = "core-image-minimal"