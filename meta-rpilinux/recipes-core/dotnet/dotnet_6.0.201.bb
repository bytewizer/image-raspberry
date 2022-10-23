DESCRIPTION = ".NET Core 6.0 Runtime (v6.0.10) - Linux x64 Binaries"
HOMEPAGE = "https://dotnet.microsoft.com/en-us/download/dotnet/6.0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "patchelf-native"

RDEPENDS:${PN} = "\
    icu \
    libgssapi-krb5 \
    zlib \
"
SRC_FETCH_ID = "33c6e1e3-e81f-44e8-9de8-91934fba3c94/9105f95a9e37cda6bd0c33651be2b90a"

SRC_URI[sha256sum] = "5adeb3b91974e13b21b1b9e6c6dd6961a3b42236b0540f96ef1430fa03eb6774"
SRC_URI = "https://download.visualstudio.microsoft.com/download/pr/${SRC_FETCH_ID}/dotnet-sdk-${PV}-linux-arm64.tar.gz;subdir=dotnet-${PV}"

DOTNET_RUNTIME = "6.0.3"
DOTNET_ASP = "6.0.3"
DOTNET_TEMPLATES = "6.0.3"
DOTNET_MANIFESTS = "6.0.200"

FILES:${PN} += "\
    ${datadir}/dotnet/dotnet \
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
    cp -r --no-preserve=ownership ${S}/host/fxr/${DOTNET_RUNTIME} ${D}${datadir}/dotnet/host/fxr

    install -d ${D}${datadir}/dotnet/sdk
    cp -r --no-preserve=ownership ${S}/sdk/${PV} ${D}${datadir}/dotnet/sdk

    install -d ${D}${datadir}/dotnet/sdk-manifests
    cp -r --no-preserve=ownership ${S}/sdk-manifests/${DOTNET_MANIFESTS} ${D}${datadir}/dotnet/sdk-manifests

    install -d ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App
    cp -r --no-preserve=ownership ${S}/shared/Microsoft.NETCore.App/${DOTNET_RUNTIME} ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App

    install -d ${D}${datadir}/dotnet/shared/Microsoft.AspNetCore.App
    cp -r --no-preserve=ownership ${S}/shared/Microsoft.AspNetCore.App/${DOTNET_ASP} ${D}${datadir}/dotnet/shared/Microsoft.AspNetCore.App

    install -d ${D}${datadir}/dotnet/templates
    cp -r --no-preserve=ownership  ${S}/templates/${DOTNET_TEMPLATES} ${D}${datadir}/dotnet/templates
    
    # Hack to fix liblttng-ust dependency issues
    patchelf --remove-needed liblttng-ust.so.0 ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${DOTNET_RUNTIME}/libcoreclrtraceptprovider.so

}

INSANE_SKIP:${PN} = "already-stripped libdir staticdev"

BBCLASSEXTEND = "native"
