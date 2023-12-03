# Allow group sudo group members to use sudo w/o password.

do_install:append () {
	echo "" >> ${D}${sysconfdir}/sudoers
	echo "# meta-custom" >> ${D}${sysconfdir}/sudoers
	echo "%sudo ALL=(ALL:ALL) NOPASSWD: ALL" >> ${D}${sysconfdir}/sudoers
    echo 'Defaults secure_path="/usr/sbin:/usr/bin:/sbin:/bin"' >> ${D}${sysconfdir}/sudoers
}
