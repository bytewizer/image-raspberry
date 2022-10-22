require recipes-core/images/core-image-minimal.bb

SPLASH = "psplash-raspberrypi"

HOSTNAME:pn-base-files = "reterminal"

IMAGE_FEATURES:append = " \
		splash \
	"

IMAGE_INSTALL:append = " \
		kernel-modules \
		seeed-linux-dtoverlays \
	"