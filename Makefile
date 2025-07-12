APP_NAME = gosugar
SOURCE_DIR = ./dist
BIN_DIR = ./bin

# Ensure the bin directories exist
$(BIN_DIR)/linux:
	mkdir -p $(BIN_DIR)/linux	
$(BIN_DIR)/windows:	
	mkdir -p $(BIN_DIR)/windows	
$(BIN_DIR)/macos:	
	mkdir -p $(BIN_DIR)/macos

all: clean build

build: linux windows macos

linux:
	GOOS=linux GOARCH=amd64 go build -o $(BIN_DIR)/linux/$(APP_NAME) $(SOURCE_DIR)/main.go

windows:
	GOOS=windows GOARCH=amd64 go build -o $(BIN_DIR)/windows/$(APP_NAME).exe $(SOURCE_DIR)/main.go

macos:
	GOOS=darwin GOARCH=amd64 go build -o $(BIN_DIR)/macos/$(APP_NAME) $(SOURCE_DIR)/main.go

clean:
	rm -f $(BIN_DIR)/linux/$(APP_NAME)
	rm -f $(BIN_DIR)/windows/$(APP_NAME).exe
	rm -f $(BIN_DIR)/macos/$(APP_NAME)

.PHONY: all build linux windows macos clean
