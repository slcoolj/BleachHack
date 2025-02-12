/*
 * This file is part of the BleachHack distribution (https://github.com/BleachDrinker420/BleachHack/).
 * Copyright (c) 2021 Bleach and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package bleach.hack.command.commands;

import com.google.gson.JsonPrimitive;

import bleach.hack.command.Command;
import bleach.hack.command.CommandCategory;
import bleach.hack.module.ModuleManager;
import bleach.hack.module.mods.DiscordRPCMod;
import bleach.hack.util.BleachLogger;
import bleach.hack.util.file.BleachFileHelper;

public class CmdRpc extends Command {

	public CmdRpc() {
		super("rpc", "Sets custom discord rpc text.", "rpc <top text> <bottom text>", CommandCategory.MODULES,
				"discordrpc");
	}

	@Override
	public void onCommand(String alias, String[] args) throws Exception {
		if (args.length != 2) {
			printSyntaxError();
			return;
		}

		((DiscordRPCMod) ModuleManager.getModule("DiscordRPC")).setText(args[0], args[1]);

		BleachLogger.infoMessage("Set RPC to " + args[0] + ", " + args[1]);

		BleachFileHelper.saveMiscSetting("discordRPCTopText", new JsonPrimitive(args[0]));
		BleachFileHelper.saveMiscSetting("discordRPCBottomText", new JsonPrimitive(args[1]));
	}

}
