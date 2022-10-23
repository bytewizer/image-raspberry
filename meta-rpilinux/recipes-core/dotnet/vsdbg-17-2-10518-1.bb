DESCRIPTION = ".NET Core Debugger (v17.2.10518.1) - Linux x64 Binaries"
HOMEPAGE = "https://github.com/Microsoft/MIEngine/wiki/Offroad-Debugging-of-.NET-Core-on-Linux---OSX-from-Visual-Studio"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "3e917d83500723545deecf54ceedda5f8bfaa422b3e8954732719d5d45041830q"
SRC_URI = "https://vsdebugger.azureedge.net/vsdbg-${PV}/vsdbg-linux-x64.zip"

# DEPENDS = "patchelf-native"

# RDEPENDS_${PN} += "\
#     libcurl \
#     libgssapi-krb5\
#     zlib \
# "

FILES_${PN}-net += "\
    ${datadir}/vsdbg/*.dll \
    ${datadir}/vsdbg/**/*.dll \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${datadir}/vsdbg
    cp -av --no-preserve=ownership ${S} ${D}${datadir}/vsdbg
    # chmod +x ${D}${datadir}/vsdbg/vsdbg
    # patchelf --set-interpreter /lib/ld-linux-x86-64.so.2 ${D}${datadir}/vsdbg/vsdbg
}

INSANE_SKIP_${PN} += "libdir ldflags"

BBCLASSEXTEND = "native"