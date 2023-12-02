# CUPS for Raspi using Yocto Project / OpenEmbedded

**IN PROGRESS**

FIXME: Write readme
       - build instructions
       - how to use
FIXME: Setup user pi with password raspberry
FIXME: CUPS + web view
FIXME: Setup sudoers
FIXME: systemd or sysvinit or mdev-busybox

```sh
# Setup your system to build OpenEmbedded/Yocto Project or use a container
docker run --privileged -it --rm --volume oe-workspace:/home/builder/workspace --name poky oe-builder

# Clone this repo
git clone https://github.com/ManuW/oe-cups.git
cd oe-cups

# Checkout required OpenEmbedded layers
kas checkout cups-raspi2.yml 

# Build the image
kas build cups-raspi2.yml 
```

## VSCode Workspace Settings

See file `.vscode/settings.json`.

- Update settings to find files in folder layers

- Specific [Yocto Project BitBake](https://marketplace.visualstudio.com/items?itemName=yocto-project.yocto-bitbake) extension settings
