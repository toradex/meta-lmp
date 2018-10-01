LINUX_VERSION ?= "4.18.11"

FIO_LMP_GIT_URL ?= "source.foundries.io"
FIO_LMP_GIT_NAMESPACE ?= ""

SRCREV_machine = "ab3807dba6aac62763cec97fd2321ea05279524b"
SRCREV_meta = "1c67180cfe3daae94cd7835edcf72b857fabaf90"
KBRANCH = "linux-v4.18.y"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = "git://${FIO_LMP_GIT_URL}/${FIO_LMP_GIT_NAMESPACE}linux.git;protocol=https;branch=${KBRANCH};name=machine; \
    git://${FIO_LMP_GIT_URL}/${FIO_LMP_GIT_NAMESPACE}lmp-kernel-cache.git;protocol=https;type=kmeta;name=meta;branch=master;destsuffix=${KMETA} \
"

KMETA = "kernel-meta"

require linux-lmp.inc
require linux-lmp-machine-custom.inc
