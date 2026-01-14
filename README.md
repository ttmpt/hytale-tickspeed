# Hytale TickSpeed Mod

This is a simple mod for the game Hytale that allows you to modify the global tickspeed.

The mod adds a new command: /tickspeed <number>  
Values above 1.0 speed the game up, values below 1.0 slow the game down (multiplier).

## Development

Compile mod:
```sh
./gradlew clean jar
```

Decompile server jar:
```sh
./gradlew decompileWithVineflower
```
