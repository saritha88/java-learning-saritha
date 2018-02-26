package com.learning;

public enum ValidationType implements EnumType<Integer> {

	EMAIL {
		@Override
		public Integer getValue() {
			return 1;
		}
	},
	NAME {
		@Override

		public Integer getValue() {
			return 2;
		}
	},
	TELNO {
		@Override

		public Integer getValue() {
			return 3;
		}
	};

}
