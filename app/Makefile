.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

build:
	./gradlew clean build

run:
	./gradlew run

build-run: build run

lint:
	make -C app checkstyleMain

test:
	make -C app checkstyleTest

report:
	make -C app report

.PHONY: build
