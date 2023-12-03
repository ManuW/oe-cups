SUMMARY = "minimal image with cups"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL:append = " avahi-daemon avahi-utils cups nano dropbear sudo"

inherit extrausers
# user pi - password raspberry
PASSWD = "\$1\$9H9WK0ti\$8mqBYWVxFAoEJMKnf8BNz0"
EXTRA_USERS_PARAMS = "\
    useradd --system --password '${PASSWD}' --groups sudo,lp,lpadmin --create-home --shell /bin/sh pi; \
    "

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
