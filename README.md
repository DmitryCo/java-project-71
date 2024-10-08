# <h1 align="center">Difference Calculator</h1>
### Hexlet tests and linter status:
[![Actions Status](https://github.com/DmitryCo/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/DmitryCo/java-project-71/actions)
[![Java CI](https://github.com/DmitryCo/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/DmitryCo/java-project-71/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/3a2adf47d317d2e36526/maintainability)](https://codeclimate.com/github/DmitryCo/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/3a2adf47d317d2e36526/test_coverage)](https://codeclimate.com/github/DmitryCo/java-project-71/test_coverage)

### Description
A difference calculator is a program that determines the difference between two data structures.

### Features:
* Support for different input formats: yaml and json
* Report generation in plain text, style and json formats

### Setup:
```bash
    git clone git@github.com:DmitryCo/java-project-71.git
    cd java-project-71
    make build
```

### Install:
```bash
    make install
```

### Help
```bash
   ./build/install/app/bin/app -h
```

### Run and select a comparison format
```bash
    ./build/install/app/bin/app filepath1.json filepath2.json
    ./build/install/app/bin/app -f format filepath1.json filepath2.json
```

### App launch examples (asciinema format):
#### Comparing two JSON documents
[![asciicast](https://asciinema.org/a/E8scU0beHlzA39fLRkofhgohd.svg)](https://asciinema.org/a/E8scU0beHlzA39fLRkofhgohd)

#### Comparing two YAML documents
[![asciicast](https://asciinema.org/a/unalewbPknF1FPbEhkjaHNMIy.svg)](https://asciinema.org/a/unalewbPknF1FPbEhkjaHNMIy)

#### Comparing two JSON and YAML documents with nested structure
[![asciicast](https://asciinema.org/a/FuOJud4KANHWJGQYVke6KYwRe.svg)](https://asciinema.org/a/FuOJud4KANHWJGQYVke6KYwRe)

#### Comparing two JSON and YAML documents with a plain format
[![asciicast](https://asciinema.org/a/3Hxx5Xz6p3Al7b79LRTQQBEOZ.svg)](https://asciinema.org/a/3Hxx5Xz6p3Al7b79LRTQQBEOZ)

#### Comparing two JSON and YAML documents with a json format
[![asciicast](https://asciinema.org/a/oWrfA653PEfezHxFOa3Du1VFc.svg)](https://asciinema.org/a/oWrfA653PEfezHxFOa3Du1VFc)