SUMMARY = "minimal image with cups"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

INIT_MANAGER = "systemd"

IMAGE_INSTALL:append = " cups nano dropbear zeroconf sudo zsh"
DISTRO_FEATURES:append = " zeroconf usbhost systemd pam"

hostname:pn-base-files = "cups"

inherit extrausers
# password builder
EXTRA_USERS_PARAMS = "\
    useradd --system --password '$1$imVLN45Z$GsGd7Yt4sa9.QRli20O6R1' --groups sudo --create-home --shell /bin/zsh builder; \
    "

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
