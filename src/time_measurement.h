#pragma once
#include <chrono>

namespace timing
{
	template<typename FnParse, typename FnReset>
	double measure(FnParse parse, FnReset reset, int sample_amount = 1000) // the weighted average of 100 times
	{
		double sum = 0;
		for (int i = 0; i < sample_amount; i++)
		{
			auto now = std::chrono::high_resolution_clock::now();
			parse();
			auto then = std::chrono::high_resolution_clock::now();
			double time = std::chrono::duration_cast<std::chrono::microseconds>(then - now).count() / 1000.0;
			sum += time;
			reset();
		}
		return sum / sample_amount;
	}

	void measure_expressions();
}