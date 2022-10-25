DESCRIPTION = ".NET Core Debugger (v17.2.10518.1) - Linux x64 Binaries"
HOMEPAGE = "https://github.com/Microsoft/MIEngine/wiki/Offroad-Debugging-of-.NET-Core-on-Linux---OSX-from-Visual-Studio"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "dbd5c399214ccdc88cf19eca550b3351eb38e4534b55dafcafed4197ef5fd253"
SRC_URI = "https://vsdebugger.azureedge.net/vsdbg-17-2-10518-1/vsdbg-linux-x64.tar.gz"

DEPENDS = "patchelf-native"

RDEPENDS_${PN} += "\
    libcurl \
    libgssapi-krb5\
    zlib \
"

# FILES_${PN}-net += "\
#     ${datadir}/vsdbg/*.dll \
#     ${datadir}/vsdbg/**/*.dll \
# "
# FILES_${PN} += "\
#     ${bindir}/*
#     ${datadir}/vsdbg \
#     ${datadir}/vsdbg/* \
#     ${datadir}/vsdbg/vsdbg \
#     ${datadir}/vsdbg/*.txt \
# "
# FILES_${PN} += "\
#     ${datadir}/vsdbg/vsdbg \
#     ${datadir}/vsdbg \
#     ${D}${bindir}/vsdbg \
#     ${datadir}/vsdbg/* \
# "

S = "${WORKDIR}/vsdbg-linux-x64-${PV}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    echo ${S}
    echo ${D}
    echo ${D}${datadir}
    echo ${WORKDIR}
    
    # install -d ${D}${bindir}
    # ln -rs ${D}${datadir}/vsdbg/vsdbg ${D}${bindir}/vsdbg
    
    # install -d ${D}${datadir}/vsdbg
    # install -m 0755 ${S}/vsdbg ${D}${datadir}/vsdbg
    # install -m 0644 ${S}/license.txt ${D}${datadir}/vsdbg
    #install -m 0644 ${S}/ThirdPartyNotices.txt ${D}${datadir}/vsdbg

    #install -m 0755 ${S} ${D}${datadir}/vsdbg
    #find ${S} -mindepth 1 -maxdepth 1 -type d ! -regex '\(.*a\|.*b\)' -exec cp -r {} ${S} ${D}${datadir}/vsdbg \;

    #cp -r --no-preserve=ownership  ${WORKDIR}  ${D}${datadir}/vsdbg
    #rsync -a --exclude={'image'} ${S} ${D}${datadir}/vsdbg
    
    #shopt -s extglob
    #cp -r ${S}!(image) ${D}${datadir}/vsdbg/
    #find ${S} -type f -not -iname '*/image/*' -exec cp '{}' '/dest/{}' ';'
    #ls | grep -Pv '^(a|b)$' | xargs -I cp -r ${S} ${D}${datadir}/vsdbg/
    # chmod +x ${D}${datadir}/vsdbg/vsdbg
    
    # install -d ${D}${bindir}
    # ln -rs ${D}${datadir}/vsdbg/vsdbg ${D}${bindir}/vsdbg
    
    #install -m 0755 ${S} ${D}${datadir}/vsdbg
    
    #install -m 0644 ${S}/license.txt ${D}${datadir}/vsdbg
    #install -m 0644 ${S}/ThirdPartyNotices.txt ${D}${datadir}/vsdbg

    # install -d ${D}${datadir}/vsdbg
    # install -m 0755 ${S}/vsdbg ${D}${datadir}/vsdbg
    # cp -r -v --no-preserve=ownership ${S} ${D}${datadir}/vsdbg

    
    
    # install -d ${D}${datadir}/vsdbg
    # cp -av --no-preserve=ownership ${S} ${D}${datadir}/vsdbg
    # chmod +x ${D}${datadir}/vsdbg/vsdbg
    # patchelf --set-interpreter /lib/ld-linux-x86-64.so.2 ${D}${datadir}/vsdbg/vsdbg
}

INSANE_SKIP_${PN} += "libdir ldflags"

BBCLASSEXTEND = "native"