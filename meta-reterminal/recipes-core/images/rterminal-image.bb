require recipes-core/images/core-image-minimal.bb

SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES:append = " \
	splash \
	"

IMAGE_INSTALL:append = " \
	kernel-modules \
	seeed-linux-dtoverlays \
	i2c-tools \
	openssh-sftp-server\
	openssh \
	openssl \
	curl \ 
	"

IMAGE_INSTALL:append:dual-gbe-cm4 = "kernel-module-lan7800"
IMAGE_INSTALL:append:dual-gbe-cm4-mender = "kernel-module-lan7800"