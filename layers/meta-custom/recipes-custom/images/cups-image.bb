SUMMARY = "minimal image with cups"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

INIT_MANAGER = "systemd"

IMAGE_INSTALL:append = " cups nano dropbear zeroconf sudo zsh"
DISTRO_FEATURES:append = " zeroconf usbhost systemd pam"

inherit extrausers
EXTRA_USERS_PARAMS = "\
    useradd --system --password '$1$lVAtKc1h$1PpNV7uyR99auCtwcugqt.' --groups sudo --create-home --shell /bin/zsh mawe; \
    "

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
