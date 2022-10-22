DESCRIPTION = ".NET Core 6.0 Runtime (v6.0.10) - Linux x64 Binaries"
HOMEPAGE = "https://dotnet.microsoft.com/en-us/download/dotnet/6.0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9fc642ff452b28d62ab19b7eea50dfb9"

DEPENDS = "patchelf-native"
RDEPENDS:${PN} = "\
    icu \
    libgssapi-krb5 \
    zlib \
"

RDEPENDS:${PN}:remove:class-native = "libgssapi-krb5"
INSANE_SKIP:${PN} = "already-stripped libdir staticdev"

SRC_FETCH_ID = "21bc0b9c-669f-4d59-9e6b-d16d1917afc0/fd3fce1337cef07b2e3763d754becb05"
SRC_URI[sha512sum] = "94d182d2d80f3cc9caabbd12e3afeef4af93269a331b64276985496e4a77040785c25b85c58cfc8093f4199e8c6da6de8128157dadfed41c82d991f57df7afdd"

SRC_URI = "https://download.visualstudio.microsoft.com/download/pr/${SRC_FETCH_ID}/dotnet-runtime-${PV}-linux-arm64.tar.gz"

FILES:${PN} += "\
    ${datadir}/dotnet/*.txt \
    ${datadir}/dotnet/host \
    ${datadir}/dotnet/shared \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${bindir}
    ln -rs ${D}${datadir}/dotnet/dotnet ${D}${bindir}/dotnet

    install -d ${D}${datadir}/dotnet
    install -m 0755 ${S}/dotnet ${D}${datadir}/dotnet
    install -m 0644 ${S}/LICENSE.txt ${D}${datadir}/dotnet
    install -m 0644 ${S}/ThirdPartyNotices.txt ${D}${datadir}/dotnet

    install -d ${D}${datadir}/dotnet/host/fxr
    cp -r --no-preserve=ownership ${S}/host/fxr/${PV} ${D}${datadir}/dotnet/host/fxr

    install -d ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App
    cp -r --no-preserve=ownership ${S}/shared/Microsoft.NETCore.App/${PV} ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App

    install -d ${D}${datadir}/dotnet/shared/Microsoft.AspNetCore.App
    cp -r --no-preserve=ownership ${S}/shared/Microsoft.AspNetCore.App/${PV} ${D}${datadir}/dotnet/shared/Microsoft.AspNetCore.App

    # Hack to fix liblttng-ust dependency issues
    patchelf --remove-needed liblttng-ust.so.0 ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${PV}/libcoreclrtraceptprovider.so
}

BBCLASSEXTEND = "native"




# DESCRIPTION = ".NET Core 6.0 (v6.0.8) runtime - Linux x64 Binaries"
# HOMEPAGE = "https://dotnet.microsoft.com/en-us/download/dotnet/6.0"
# LICENSE = "MIT"
# LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9fc642ff452b28d62ab19b7eea50dfb9"

# SRC_URI = "https://download.visualstudio.microsoft.com/download/pr/866ce4df-8aaa-417d-ad81-26131a2b8734/7ba8391188bc194156ee7d82f494ee00/dotnet-runtime-6.0.8-linux-arm64.tar.gz;subdir=dotnet-${PV}"

# SRC_URI[md5sum] = "e63d7af97b027a661d4bb1d575a4f302"
# SRC_URI[sha256sum] = "3ca0cc3475e845afea3adcff0b5faa28c293fb9803a812280619453a6f3984ca"

# S = "${WORKDIR}/dotnet-${PV}"

# DEPENDS = "zlib"
# RDEPENDS_${PN} = "lttng-tools lttng-ust zlib icu libssl"

# INSANE_SKIP_${PN} += "already-stripped libdir textrel"

# do_configure[noexec] = "1"
# do_compile[noexec] = "1"

# FILES_${PN} += " \
# 	${datadir}/dotnet \
# 	/usr/local/share/dotnet \
# 	"

# do_install() {
# 	install -d ${D}${bindir}
# 	install -d ${D}${datadir}/dotnet/
# 	install -m 0755 ${S}/dotnet ${D}${datadir}/dotnet/
# 	install -m 0644 ${S}/LICENSE.txt ${D}${datadir}/dotnet/
# 	install -m 0644 ${S}/ThirdPartyNotices.txt ${D}${datadir}/dotnet/

# 	install -d ${D}${datadir}/dotnet/host/fxr/${PV}/
# 	install -m 0755 ${S}/host/fxr/${PV}/libhostfxr.so ${D}${datadir}/dotnet/host/fxr/${PV}/

# 	install -d ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${PV}/
	
# 	install -m 0644 ${S}/shared/Microsoft.NETCore.App/${PV}/.version ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${PV}/.version
# 	install -m 0644 ${S}/shared/Microsoft.NETCore.App/${PV}/createdump ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${PV}/createdump
# 	for file in ${S}/shared/Microsoft.NETCore.App/${PV}/*.so; do
# 		install -m 0755 "$file" ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${PV}/
# 	done
# 	for file in ${S}/shared/Microsoft.NETCore.App/${PV}/*.dll; do
# 		install -m 0644 "$file" ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${PV}/
# 	done
# 	for file in ${S}/shared/Microsoft.NETCore.App/${PV}/*.json; do
# 		install -m 0644 "$file" ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${PV}/
# 	done
# 	install -d ${D}/usr/local/share

# 	cd ${D}/usr/local/share
# 	ln -s ../../share/dotnet ${D}/usr/local/share
# 	cd ${D}${bindir}
# 	ln -s ../share/dotnet/dotnet ${D}${bindir}/dotnet
# }


# DESCRIPTION = ".NET Core 5.0 SDK (v6.0.4) - Linux x64 Binaries"
# HOMEPAGE = "https://dotnet.microsoft.com/en-us/download/dotnet/6.0"
# LICENSE = "MIT"
# LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8ae806bcd6ac97fb7f2b0e270b4a1edf"

# SOURCE_FILE = "dotnet-sdk-6.0.402-linux-x64.tar.gz"

# SRC_URI = "https://download.visualstudio.microsoft.com/download/pr/d3e46476-4494-41b7-a628-c517794c5a6a/6066215f6c0a18b070e8e6e8b715de0b/${SOURCE_FILE};unpack=0 \
#            file://LICENSE.txt \
# "
# SRC_URI[sha512sum] = "972c2d9fff6a09ef8f2e6bbaa36ae5869f4f7f509ae5d28c4611532eb34be10c629af98cdf211d86dc4bc6edebb04a2672a97f78c3e0f2ff267017f8c9c59d4e"

# inherit native

# S="${WORKDIR}"

# do_install() {
#     echo "Installing ${DESCRIPTION} ..."

#     install -d ${D}${bindir}
#     tar -xvzf ${WORKDIR}/${SOURCE_FILE} -C ${D}${bindir}
# }