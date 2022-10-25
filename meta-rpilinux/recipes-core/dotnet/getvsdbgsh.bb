DESCRIPTION = ""
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "2608424ae05550a24ac9b767a997635de1e87fe551156536d03356da421f4c64"
SRC_URI = "https://aka.ms/getvsdbgsh"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {    
    install -d ${D}${bindir}
    install -m 0770 ${WORKDIR}/getvsdbgsh ${D}/${bindir}/GetVsDbg.sh
}