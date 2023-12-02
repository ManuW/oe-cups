SUMMARY = "minimal image with cups"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL:append = " cups nano dropbear sudo"

inherit extrausers
# password builder
PASSWD = "\$1\$imVLN45Z\$GsGd7Yt4sa9.QRli20O6R1"
EXTRA_USERS_PARAMS = "\
    useradd --system --password '$PASSWD' --groups sudo --create-home --shell /bin/sh builder; \
    "

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
