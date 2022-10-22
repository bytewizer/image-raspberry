#
# Enable wireless features
#
DISTRO_FEATURES:append = " wifi "
IMAGE_INSTALL:append = " linux-firmware-rpidistro-bcm43430 "

#
# Set root password
# using openssl passwd p@ssw0rd
#
# INHERIT += "extrausers"
# EXTRA_USERS_PARAMS = "usermod -p yKMNZ4imKnbb6 root;"

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