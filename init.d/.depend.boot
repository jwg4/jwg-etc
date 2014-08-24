TARGETS = fake-hwclock mountkernfs.sh hostname.sh udev keyboard-setup mountdevsubfs.sh console-setup checkroot.sh networking mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh alsa-utils urandom x11-common kbd mtab.sh bootmisc.sh kmod screen-cleanup checkfs.sh procps plymouth-log udev-mtab checkroot-bootclean.sh
INTERACTIVE = udev keyboard-setup console-setup checkroot.sh kbd checkfs.sh
udev: mountkernfs.sh
keyboard-setup: mountkernfs.sh udev
mountdevsubfs.sh: mountkernfs.sh udev
console-setup: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh kbd
checkroot.sh: fake-hwclock keyboard-setup mountdevsubfs.sh hostname.sh
networking: mountkernfs.sh mountall.sh mountall-bootclean.sh urandom
mountall.sh: checkfs.sh checkroot-bootclean.sh
mountall-bootclean.sh: mountall.sh
mountnfs.sh: mountall.sh mountall-bootclean.sh networking
mountnfs-bootclean.sh: mountall.sh mountall-bootclean.sh mountnfs.sh
alsa-utils: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh
urandom: mountall.sh mountall-bootclean.sh
x11-common: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh
kbd: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh
mtab.sh: checkroot.sh
bootmisc.sh: mountnfs-bootclean.sh mountall-bootclean.sh mountall.sh mountnfs.sh udev checkroot-bootclean.sh
kmod: checkroot.sh
screen-cleanup: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh
checkfs.sh: checkroot.sh mtab.sh
procps: mountkernfs.sh mountall.sh mountall-bootclean.sh udev
plymouth-log: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh
udev-mtab: udev mountall.sh mountall-bootclean.sh
checkroot-bootclean.sh: checkroot.sh
