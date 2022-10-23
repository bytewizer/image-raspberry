#
# Enable wireless features
#
DISTRO_FEATURES:append = " wifi "
IMAGE_INSTALL:append = " linux-firmware-rpidistro-bcm43430 "

#
# Install additional image features
#
IMAGE_INSTALL.append = " \
		openssh-sftp-server\
		openssh \
		openssl \
        dotnet-core \
        i2c-tools \
		nano \
		curl \
	"