# Yet Another Linux Distro - Build Repository

## Build

```
$ git clone https://github.com/meisteg/yald-build.git
$ cd yald-build
$ ./repo-mgr.sh init
$ docker run --rm -t -v $(pwd):/workdir -e MACHINE=<machine name> crops/poky:ubuntu-22.04 --workdir=/workdir /workdir/run-build.sh
```

### Supported machines

- raspberrypi3-64
- raspberrypi4-64