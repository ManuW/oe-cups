# CUPS for Raspi using Yocto Project / OpenEmbedded

**IN PROGRESS**

FIXME: Write readme
       - build instructions
       - how to use
FIXME: systemd or sysvinit or mdev-busybox
FIXME: My printer is not available ☹️
       Driver is missing. Maybe there is a ppd file
FIXME: Change cups config. Changes begin with a '§' character

```txt
# Only listen for connections from the local machine.
§ #Listen localhost:631
Listen /run/cups/cups.sock
§ Listen 0.0.0.0:631


# Restrict access to the server...
<Location />
  Order allow,deny
§ Allow from 192.168.178.*
</Location>

# Restrict access to the admin pages...
<Location /admin>
  Order allow,deny
§  Allow from 192.168.178.*
</Location>
``````


```sh
# Setup your system to build OpenEmbedded/Yocto Project or use a container
docker run -it --volume oe-workspace:/home/builder/workspace --name poky oe-builder

# Clone this repo
git clone https://github.com/ManuW/oe-cups.git
cd oe-cups

# Checkout required OpenEmbedded layers
kas checkout cups-raspi2.yml 

# Build the image
kas build cups-raspi2.yml
```

Now it takes a (long) time to build the image.

The result can be found in the folder `build/tmp/deploy/images/raspberrypi2/`.

If you work in a container, copy the image to your PC

```sh
# Compressed image
docker cp poky:/home/builder/workspace/oe-cups/build/tmp/deploy/images/raspberrypi2/cups-image-raspberrypi2-20231203083248.rootfs.wic.bz2 ~/Downloads
# required if you want to use bmap-tool
docker cp poky:/home/builder/workspace/oe-cups/build/tmp/deploy/images/raspberrypi2/cups-image-raspberrypi2-20231203083248.rootfs.wic.bmap ~/Downloads
```

Uncompress and copy the image using e.g. dd

```sh
bzcat cups-image-raspberrypi2-20231203083248.rootfs.wic.bz2 | sudo dd of=/dev/rdisk10 bs=1M status=progress
```

After booting the raspi, you can login over ssh into the system

```sh
# password: raspberry
ssh pi@cups.local
```

## VSCode Workspace Settings

See file `.vscode/settings.json`.

- Update settings to find files in folder layers

- Specific [Yocto Project BitBake](https://marketplace.visualstudio.com/items?itemName=yocto-project.yocto-bitbake) extension settings
