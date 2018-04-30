# SunkenNavalShips
SunkenNavalShipsはMinecraftの世界に沈没艦を生成するmodです。

## Versions
- v 1.1.0 for Minecraft 1.12(.x)

## Downloads
Releasesページの**Assets**にある **SunkenNavalShips-(Minecraftバージョン)-(modバージョン).jar** をクリックしてください。

- [Releases (from GitHub)](https://github.com/Iunius118/SunkenNavalShips/releases)

## Features
- このmodを導入すると、海洋・深海バイオームに一定確率で「沈没艦」が生成されるようになります
- 生成される沈没艦は（なぜか）現実世界の20世紀前半に建造された海軍の駆逐艦に似ています
- 各艦は沈没してから大分時間が経っているらしく、船体は損傷し大部分が鉄鉱石ブロックによって構成されています
- 沈没艦の生成率はゲーム内configでも変更することができます

## Description
### 生成される沈没艦について
以下の文書を参照してください。

- [ships.md](ships.md)

### Configuration
ゲームメニューのmodリストからSunkenNavalShipsを選択し、Configボタンを押すと設定画面に移動します。
設定画面では以下の項目が変更できます。

- sunkenShipProbability
  - 沈没艦の生成確率を設定します
  - 値は0～100の整数で、大きいほど生成確率が高く、また0に設定すると沈没艦を一切生成しなくなります
  - 変更した生成確率は、変更後新たに生成された地形に対して適用されます
  - 初期値は32です

### 出力されるログについて
沈没艦の生成時には生成座標をログに出力します。

```
[sunkennavalships]: Generate SunkenDestroyer {type} between ({x1}, {z1}) - ({x2}, [z2])
```

また、沈没艦の生成時に以下のような警告ログが出力されることがありますが、これは現時点ではこのmodの仕様です。

```
[FML]: SunkenNavalShips loaded a new chunk ({chunkX}, {chunkZ}  Dimension: 0) during chunk population, causing cascading worldgen lag. Please report this to the mod's issue tracker. This log can be disabled in the Forge config.
```

---
Copyright 2018 Iunius118
