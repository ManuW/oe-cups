
PACKAGECONFIG:append = " webif"
SYSTEMD_SERVICE:${PN} = "cups.service"

FILES:${PN} += "\
    ${systemd_system_unitdir}/cups-lpd@.service \
    ${systemd_system_unitdir}/cups.socket \
    ${systemd_system_unitdir}/cups-lpd.socket \
    ${systemd_system_unitdir}/cups.path \
    "