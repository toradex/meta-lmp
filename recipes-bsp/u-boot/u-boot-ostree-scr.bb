DESCRIPTION = "Boot script for launching OSTree based images with u-boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS = "u-boot-mkimage-native"

SRC_URI = " \
    file://boot.cmd \
    file://uEnv.txt.in \
"

KERNEL_BOOTCMD ??= "bootz"
KERNEL_BOOTCMD_aarch64 ?= "booti"

S = "${WORKDIR}"

inherit deploy

do_compile() {
    sed -e 's/@@KERNEL_BOOTCMD@@/${KERNEL_BOOTCMD}/' \
        "${WORKDIR}/uEnv.txt.in" > uEnv.txt
    mkimage -A arm -T script -C none -n "Ostree boot script" -d "${WORKDIR}/boot.cmd" boot.scr
}

do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 0644 boot.scr ${DEPLOYDIR}
    install -m 0644 uEnv.txt ${DEPLOYDIR}
}

addtask do_deploy after do_compile before do_build
