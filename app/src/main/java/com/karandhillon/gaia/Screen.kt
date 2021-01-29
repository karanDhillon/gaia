package com.karandhillon.gaia

sealed class Screen(
  val route: String,
  val label: String
) {
  object Gaia: Screen("gaia", "Gaia")
  object Poseidon: Screen("poseidon", "Poseidon")
  object Zeus: Screen("zeus", "Zeus")
}