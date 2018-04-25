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


Copyright 2018 Iunius118
